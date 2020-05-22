for (String name: result.keySet())
{
    String key =name.toString();
    Long[] value = result.get(name);  
    //System.out.println(key + " " + value);

    StringBuilder record = new StringBuilder();

    record.append(key);

    for (long l : value)
    {
        record.append(", ");
        record.append(l);
    }

    pw.println(record.toString());       
}