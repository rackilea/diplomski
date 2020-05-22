List<T> results = new ArrayList<>();
Field[] theFields = clazz.getDeclaredFields();
// if overriding access right is needed:
AccessibleObject.setAccessible(theFields, true);

int numberOfFields = theFields.length;
int[] columnIndex = new int[numberOfFields];
for(int ix = 0; ix < numberOfFields; ix++) {
    Integer index = columnNames.get(theFields[ix].getName().toLowerCase());
    if(index != null) columnIndex[ix] = index + 1;
}

Constructor<T> con = clazz.getConstructor();

while(resultSet.next())
{
    T newObj = con.newInstance();
    for(int ix = 0; ix < numberOfFields; ix++)
        if(columnIndex[ix] != 0)
            theFields[ix].set(newObj, resultSet.getObject(columnIndex[ix]));
    results.add(newObj);
}