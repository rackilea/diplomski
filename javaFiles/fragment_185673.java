final class StrictEnumTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory allStrictEnumTypeAdapterFactory = new StrictEnumTypeAdapterFactory(enumClass -> true);

    private final Predicate<? super Class<? extends Enum<?>>> isStrictEnumClass;

    private StrictEnumTypeAdapterFactory(final Predicate<? super Class<? extends Enum<?>>> isStrictEnumClass) {
        this.isStrictEnumClass = isStrictEnumClass;
    }

    static TypeAdapterFactory get(final Predicate<? super Class<? extends Enum<?>>> isStrictEnumClass) {
        return new StrictEnumTypeAdapterFactory(isStrictEnumClass);
    }

    static TypeAdapterFactory get() {
        return allStrictEnumTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        final Class<? super T> rawType = typeToken.getRawType();
        // Skip non-enums
        if ( !Enum.class.isAssignableFrom(rawType) ) {
            return null;
        }
        // Check if the enum is supported by the "strict" policy
        @SuppressWarnings("unchecked")
        final Class<? extends Enum<?>> enumRawType = (Class<? extends Enum<?>>) rawType;
        if ( !isStrictEnumClass.test(enumRawType) ) {
            return null;
        }
        // Trivial rawtypes/unchecked casts
        @SuppressWarnings({ "rawtypes", "unchecked" })
        final TypeAdapter<? extends Enum<?>> strictEnumTypeAdapter = StrictEnumTypeAdapter.get((Class) enumRawType);
        @SuppressWarnings("unchecked")
        final TypeAdapter<T> castTypeAdapter = (TypeAdapter<T>) strictEnumTypeAdapter;
        return castTypeAdapter;
    }

    private static final class StrictEnumTypeAdapter<E extends Enum<E>>
            extends TypeAdapter<E> {

        private final Class<E> enumClass;
        private final Map<String, E> nameToEnumConstant;
        private final Map<E, String> enumConstantToName;

        private StrictEnumTypeAdapter(final Class<E> enumClass, final Map<String, E> nameToEnumConstant, final Map<E, String> enumConstantToName) {
            this.enumClass = enumClass;
            this.nameToEnumConstant = nameToEnumConstant;
            this.enumConstantToName = enumConstantToName;
        }

        private static <E extends Enum<E>> TypeAdapter<E> get(final Class<E> enumClass) {
            final Map<String, E> nameToEnumConstant = new HashMap<>();
            final Map<E, String> enumConstantToName = new HashMap<>();
            final Map<String, E> enumNameToEnumConstant = Stream.of(enumClass.getEnumConstants())
                    .collect(Collectors.toMap(Enum::name, Function.identity()));
            Stream.of(enumClass.getFields())
                    // It can be either a simple enum constant, or an enum constant that overrides
                    .filter(field -> enumClass.isAssignableFrom(field.getType()))
                    .forEach(field -> {
                        final E enumConstant = enumNameToEnumConstant.get(field.getName());
                        // For compatibility with the original type adapter, we have to respect the @SeriaizedName annotation
                        final SerializedName serializedName = field.getAnnotation(SerializedName.class);
                        if ( serializedName == null ) {
                            nameToEnumConstant.put(field.getName(), enumConstant);
                            enumConstantToName.put(enumConstant, field.getName());
                        } else {
                            nameToEnumConstant.put(serializedName.value(), enumConstant);
                            enumConstantToName.put(enumConstant, serializedName.value());
                            for ( final String alternate : serializedName.alternate() ) {
                                nameToEnumConstant.put(alternate, enumConstant);
                            }
                        }
                    });
            return new StrictEnumTypeAdapter<>(enumClass, nameToEnumConstant, enumConstantToName)
                    .nullSafe(); // A convenient method to handle nulls
        }

        @Override
        public void write(final JsonWriter out, final E value)
                throws IOException {
            out.value(enumConstantToName.get(value));
        }

        @Override
        public E read(final JsonReader in)
                throws IOException {
            final String key = in.nextString();
            // This is what the original type adapter probably misses
            if ( !nameToEnumConstant.containsKey(key) ) {
                throw new JsonParseException(enumClass + " does not have an enum named " + key + " at " + in);
            }
            return nameToEnumConstant.get(key);
        }

    }

}