Arrays.stream(DemoObject.class.getDeclaredFields())
            .map(Field::getGenericType)
            .distinct()
            .forEach(type -> {
                if (type instanceof Class) {
                    // This is a simple class
                } else if (type instanceof ParameterizedType) {
                    // This is a generic type. You can parse its parameters recursively.
                }
            });