public final class MoshiRuntimeTypeJsonAdapterFactory
        implements JsonAdapter.Factory {

    private static final String DEFAULT_CLASS_NAME_PROPERTY = "type";

    private final Class<?> baseClass;
    private final String classNameProperty;
    private final Map<String, Class<?>> classNameToClass = new HashMap<>();
    private final Map<Class<?>, String> classToClassName = new HashMap<>();

    private MoshiRuntimeTypeJsonAdapterFactory(final Class<?> baseClass, final String classNameProperty) {
        this.baseClass = baseClass;
        this.classNameProperty = classNameProperty;
    }

    public static MoshiRuntimeTypeJsonAdapterFactory of(final Class<?> expectedClass) {
        return new MoshiRuntimeTypeJsonAdapterFactory(expectedClass, DEFAULT_CLASS_NAME_PROPERTY);
    }

    public static MoshiRuntimeTypeJsonAdapterFactory of(final Class<?> expectedClass, final String classNameProperty) {
        return new MoshiRuntimeTypeJsonAdapterFactory(expectedClass, classNameProperty);
    }

    public MoshiRuntimeTypeJsonAdapterFactory with(final Class<?> concreteClass) {
        return with(concreteClass, concreteClass.getSimpleName());
    }

    public MoshiRuntimeTypeJsonAdapterFactory with(final Class<?> concreteClass, final String className)
            throws IllegalArgumentException {
        if ( classNameToClass.containsKey(className) ) {
            throw new IllegalArgumentException(className + " is already registered for " + concreteClass);
        }
        if ( classToClassName.containsKey(concreteClass) ) {
            throw new IllegalArgumentException(concreteClass + " is already registered for " + className);
        }
        classNameToClass.put(className, concreteClass);
        classToClassName.put(concreteClass, className);
        return this;
    }

    @Nullable
    @Override
    public JsonAdapter<?> create(final Type type, final Set<? extends Annotation> annotations, final Moshi moshi) {
        if ( !(type instanceof Class) ) {
            return null;
        }
        final Class<?> typeAsClass = (Class<?>) type;
        if ( !baseClass.isAssignableFrom(typeAsClass) ) {
            return null;
        }
        final JsonAdapter<Object> jsonObjectJsonAdapter = moshi.nextAdapter(this, Map.class, ImmutableSet.of());
        final LoadingCache<Class<?>, JsonAdapter<Object>> jsonAdaptersCache = CacheBuilder.newBuilder()
                .build(new CacheLoader<Class<?>, JsonAdapter<Object>>() {
                    @Override
                    public JsonAdapter<Object> load(final Class<?> clazz) {
                        return moshi.nextAdapter(MoshiRuntimeTypeJsonAdapterFactory.this, clazz, ImmutableSet.copyOf(clazz.getAnnotations()));
                    }
                });
        return new JsonAdapter<Object>() {
            @Nullable
            @Override
            public Object fromJson(final JsonReader jsonReader)
                    throws IOException {
                try {
                    @SuppressWarnings("unchecked")
                    final Map<String, Object> jsonObject = (Map<String, Object>) jsonReader.readJsonValue();
                    assert jsonObject != null;
                    final Object rawClassName = jsonObject.get(classNameProperty);
                    if ( !(rawClassName instanceof String) ) {
                        throw new IOException("Type name: expected a string in " + classNameProperty + ", but got " + rawClassName);
                    }
                    final String className = (String) rawClassName;
                    final Class<?> concreteClass = classNameToClass.get(className);
                    if ( concreteClass == null ) {
                        throw new IOException("No mapping registered for " + className);
                    }
                    final JsonAdapter<Object> jsonAdapter = jsonAdaptersCache.get(concreteClass);
                    return jsonAdapter.fromJsonValue(jsonObject);
                } catch ( final ExecutionException ex ) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void toJson(final JsonWriter jsonWriter, @Nullable final Object value)
                    throws IOException {
                try {
                    assert value != null;
                    final Class<?> concreteClass = value.getClass();
                    final String className = classToClassName.get(concreteClass);
                    if ( className == null ) {
                        throw new IOException("No mapping registered for " + concreteClass);
                    }
                    final JsonAdapter<Object> valueJsonAdapter = jsonAdaptersCache.get(concreteClass);
                    @SuppressWarnings("unchecked")
                    final Map<String, Object> jsonObject = (Map<String, Object>) valueJsonAdapter.toJsonValue(value);
                    assert jsonObject != null;
                    jsonObject.put(classNameProperty, className);
                    jsonObjectJsonAdapter.toJson(jsonWriter, jsonObject);
                } catch ( final ExecutionException ex ) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }

}