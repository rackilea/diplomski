/* Check if the given object is an array. */
if (object.getClass().isArray()) {

    Class<?> componentType;
    componentType = object.getClass().getComponentType();

    if (componentType.isPrimitive()) {

        if (boolean.class.isAssignableFrom(componentType)) {
            for (boolean anElement : (boolean[]) object) {
                /* ... */
            }
        }

        else if (byte.class.isAssignableFrom(componentType)) {
            /* ... */
        }

        else if (char.class.isAssignableFrom(componentType)) {
            /* ... */
        }

        else if (double.class.isAssignableFrom(componentType)) {
            /* ... */
        }

        else if (float.class.isAssignableFrom(componentType)) {
            /* ... */
        }

        else if (int.class.isAssignableFrom(componentType)) {
            /* ... */
        }

        else if (long.class.isAssignableFrom(componentType)) {
            /* ... */
        }

        else if (short.class.isAssignableFrom(componentType)) {
            /* ... */
        }

        /* No else. No other primitive types exist. */
    }

    else {
        /* Do something with Object[] here. */
    }
}