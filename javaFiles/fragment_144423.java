Map<String, Object> myObjectAsDict = new HashMap<>();    
Field[] allFields = SomeClass.class.getDeclaredFields();
    for (Field field : allFields) {
        Class<?> targetType = field.getType();
        Object objectValue = targetType.newInstance();
        Object value = field.get(objectValue);
        myObjectAsDict.put(field.getName(), value);
    }
}