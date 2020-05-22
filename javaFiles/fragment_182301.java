/**
 * Returns a list of all Fields in this object, including inherited fields.
 */
private List<Field> getFields() {
    List<Field> list = new ArrayList<Field>();
    getFields(list, getClass());
    return list;
}

/**
 * Adds the fields of the provided class to the List of Fields. 
 * Recursively adds Fields also from super classes.
 */
private List<Field> getFields(List<Field> list, Class<?> startClass) {
    for (Field field : startClass.getDeclaredFields()) {
        list.add(field);
    }
    Class<?> superClass = startClass.getSuperclass();
    if(!superClass.equals(Object.class)) {
        getFields(list, superClass);
    }
}

public void setParameters(Map<String, String> props) throws IllegalArgumentException, IllegalAccessException {
    for(Field field : getFields()) {
        if (props.containsKey(field.getName())) {
            boolean prevAccessible = field.isAccessible();
            if (!prevAccessible) {
                /*
                 * You're not allowed to modify this field. 
                 * So first, you modify it to make it modifiable.
                 */
                field.setAccessible(true);
            }
            field.set(this, props.get(field.getName()));

            /* Restore the mess you made */
            field.setAccessible(prevAccessible);
        }
    }
}