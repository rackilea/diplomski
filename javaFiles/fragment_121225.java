public static <A, B> B convert(A instance, 
                           Class<B> targetClass) throws Exception { 
    B target = (B)targetClass.newInstance(); 

    for (Field targetField : targetClass.getDeclaredFields()) { 
        targetField.setAccessible(true); 
        Field field = 
            instance.getClass().getDeclaredField(targetField.getName()); 
        field.setAccessible(true); 

        // Ignore attempts to set final fields
        try {
            targetField.set(target, field.get(instance)); 
        } catch (IllegalAccessException e) {
            continue;
        }
    } 

    return target; 
}