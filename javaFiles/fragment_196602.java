abstract class Configuration {

    private static final Gson saveGson = new Gson();

    public final void load()
            throws IOException {
        try ( final FileReader reader = new FileReader(getTargetName()) ) {
            // You have to instantiate Gson every time (unless you use caching strategies) in order to let it be *specifically* be aware of the current
            // Configuration instance class. Thus you cannot make it a static field.
            final Gson loadGson = new GsonBuilder()
                    .registerTypeAdapterFactory(new TypeAdapterFactory() {
                        // A Gson way to denote a type since Configuration.class may not be enough and it also works with generics
                        private final TypeToken<Configuration> configurationTypeToken = new TypeToken<Configuration>() {
                        };

                        @Override
                        @SuppressWarnings("deprecation") // isAssignableFrom is deprecated
                        public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
                            // Checking if the type token represents a parent class for the given configuration
                            // If yes, then we cheat...
                            if ( configurationTypeToken.isAssignableFrom(typeToken) ) {
                                // The map that's artificially bound as great cheating to a current configuration instance
                                final Map<Type, InstanceCreator<?>> instanceCreators = bindInstance(typeToken.getType(), Configuration.this);
                                // A factory used by Gson internally, we're intruding into its heart
                                final ConstructorConstructor constructorConstructor = new ConstructorConstructor(instanceCreators);
                                final TypeAdapterFactory delegatedTypeAdapterFactory = new ReflectiveTypeAdapterFactory(
                                        constructorConstructor,
                                        gson.fieldNamingStrategy(),
                                        gson.excluder(),
                                        new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor)
                                );
                                // Since the only thing necessary here is to define how to instantiate an object
                                // (and we just give it an already-existing instance)
                                // ... just delegate the job to Gson -- it would think as if it's creating a new instance.
                                // Actually it won't create one, but would "patch" the current instance
                                return delegatedTypeAdapterFactory.create(gson, typeToken);
                            }
                            // Otherwise returning a null means looking up for an existing type adapter from how Gson is configured
                            return null;
                        }
                    })
                    .create();
            // The value is still loaded to nowhere, however.
            // The type adapter factory is tightly bound to an existing configuration instance via ConstructorConstructor
            // This is actually another code smell...
            loadGson.fromJson(reader, getClass());
        }
    }

    public final void save()
            throws IOException {
        try ( final FileWriter writer = new FileWriter(getTargetName()) ) {
            saveGson.toJson(this, writer);
        }
    }

    private String getTargetName() {
        return getClass().getSimpleName() + ".json";
    }

    private static Map<Type, InstanceCreator<?>> bindInstance(final Type type, final Configuration existingConfiguration) {
        return singletonMap(type, new InstanceCreator<Object>() {
            @Override
            public Object createInstance(final Type t) {
                return t.equals(type) ? existingConfiguration : null; // don't know if null is allowed here though
            }
        });
    }

}