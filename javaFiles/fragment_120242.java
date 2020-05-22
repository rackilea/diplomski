private void setProperties(Properties properties, Props props) throws SecurityException, IllegalArgumentException, IllegalAccessException {
    Class<?> clazz = props.getClass();

    for (Field field : clazz.getDeclaredFields()) {
        if ((field.getModifiers() & Modifier.PUBLIC) == 0) {
            // ignore non-public properties
            continue;
        }

        // the type of the field
        Class<?> fieldType = field.getType();
        // the field name of the class
        String fieldName = field.getName();
        // the raw value loaded from the .properties file 
        String value = properties.getProperty(fieldName);

        // fields may be annotated with @Required
        boolean required = (field.getAnnotation(Required.class) != null);

        if (required && value == null) {
            // field required but not defined in the properties, fail 
            throw new IllegalArgumentException(
                    String.format(
                            "Field %s is required",
                            fieldName
                    )
            );
        } else if (value == null) {
            // ignore undefined field, default to class initialized value
            continue;
        }

        // checks per type follow ...

        if (fieldType == String.class) {
            // fields may be annotated with RegExp to specify a matcher
            RegExp regExp = field.getAnnotation(RegExp.class);

            if (regExp != null && !Pattern.matches(regExp.value(), value)) {
                throw new IllegalArgumentException(
                        String.format(
                                "Value for field %s does not match %s: %s",
                                fieldName,
                                regExp.value(),
                                value
                        )
                );
            }

            field.set(props, value);
        } else if (fieldType == Integer.class) {
            // may throw NumberFormatException if not a valid integer
            Integer intValue = Integer.parseInt(value);

            // fields may be annotated with Range to specify an integer range
            Range range = field.getAnnotation(Range.class);

            if (range != null && !(intValue >= range.min() && intValue <= range.max())) {
                throw new IllegalArgumentException(
                        String.format(
                                "Value for field %s out of range (%d..%d): %d",
                                fieldName,
                                range.min(),
                                range.max(),
                                intValue
                        )
                );
            }

            field.set(props, intValue);
        } else if (fieldType == Boolean.class) {
            // strictly check valid boolean values 
            if (!Pattern.matches("^(true|false)$", value)) {
                throw new IllegalArgumentException(
                        String.format(
                                "Value for field %s is not a valid boolean (true|false): %s",
                                fieldName,
                                value
                        )
                );
            }

            field.set(props, Boolean.parseBoolean(value));
        }
    }
}