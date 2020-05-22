private void instantiateNestedProperties(Object obj, String fieldName) {
    try {
        String[] fieldNames = fieldName.split("\\.");
        if (fieldNames.length > 1) {
            StringBuffer nestedProperty = new StringBuffer();
            for (int i = 0; i < fieldNames.length - 1; i++) {
                String fn = fieldNames[i];
                if (i != 0) {
                    nestedProperty.append(".");
                }
                nestedProperty.append(fn);

                Object value = PropertyUtils.getProperty(obj, nestedProperty.toString());

                if (value == null) {
                    PropertyDescriptor propertyDescriptor = PropertyUtils.getPropertyDescriptor(obj, nestedProperty.toString());
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    Object newInstance = propertyType.newInstance();
                    PropertyUtils.setProperty(obj, nestedProperty.toString(), newInstance);
                }
            }
        }
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
        throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
        throw new RuntimeException(e);
    } catch (InstantiationException e) {
        throw new RuntimeException(e);
    }
}