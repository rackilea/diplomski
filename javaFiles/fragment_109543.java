Field[] fields = R.layout.class.getDeclaredFields();
for(Field f : fields)
{
    String fieldName = f.getName();
    int fieldValue = (Integer) f.get(new Integer(0));
    // ...
}