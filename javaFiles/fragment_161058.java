List<T> results = new ArrayList<>();
Field[] theFields = clazz.getDeclaredFields();
// if overriding access right is needed:
AccessibleObject.setAccessible(theFields, true);

while(resultSet.next())
{
    T newObj = clazz.newInstance();
    for (Field field: theFields) 
    {
        Integer index = columnNames.get(field.getName().toLowerCase());
        if(index != null)
            field.set(newObj, resultSet.getObject(index+1));
    }
    results.add(newObj);
}