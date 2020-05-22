class ActualGenericTypeExtractor {

    public static Class<?> extractFromType(Type type) {
        // check if it is a waw type
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Raw type has been found! Specify a generic type for further scanning.");
        }

        // return the first generic type
        return (Class<?>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

}

class SortingKeyExtractor {

    @SuppressWarnings("unchecked")
    public static <T> Function<T, Comparable<? super Object>> extractFromClassByFieldName(Class<?> type, String fieldName) throws NoSuchFieldException, NoSuchMethodException {
        // check if the fieldName is in allowed fields
        validateFieldName(type, fieldName);

        // fetch a key-extractor method
        Method method = findExtractorForField(type, type.getDeclaredField(fieldName));

        // form a Function with a method invocation inside
        return (T instance) -> {
            try {
                return (Comparable<? super Object>) method.invoke(instance);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        };
    }

    private static Method findExtractorForField(Class<?> type, Field field) throws NoSuchMethodException {
        // generate the default name for a getter
        String fieldName = "get" + StringUtil.capitalize(field.getName());

        // override it if specified by the annotation
        if (field.isAnnotationPresent(FieldExtractor.class)) {
            fieldName = field.getAnnotation(FieldExtractor.class).getterName();
        }

        System.out.println("> Fetching a method with the name [" + fieldName + "]...");

        return type.getDeclaredMethod(fieldName);
    }

    private static void validateFieldName(Class<?> type, String fieldName) {
        if (!type.isAnnotationPresent(SortingFields.class)) {
            throw new IllegalArgumentException("A list of sorting fields hasn't been specified!");
        }

        SortingFields annotation = type.getAnnotation(SortingFields.class);

        for (String field : annotation.fields()) {
            if (field.equals(fieldName)) {
                System.out.println("> The given field name [" + fieldName + "] is allowed!");
                return;
            }
        }

        throw new IllegalArgumentException("The given field is not allowed to be a sorting key!");
    }

}