class CallLevel
{
    CallLevel(Object target, int level) {
        this.target = target; this.level = level;
    }
    Object target;
    int level;
}
public static String dumpFields(Object start)
{
    List<CallLevel> workList = new ArrayList<CallLevel>();
    workList.add(new Calllevel(start,0));
    Map idHashMap = new IdentityHashMap();

    while (!workList.isEmpty()) {
        CallLevel level = workList.removeAt(workList.size()-1);
        Object o = level.object;
    //add this object to the exclude list to avoid circual references in the future
    idHashMap.put(, o);

    //setup string buffer and add fields
    StringBuffer tabs = new StringBuffer();
    int callCount = level.level;
    for (int k = 0; k < callCount; k++)
    {
        tabs.append("\t");
    }
    callCount++;
    StringBuffer buffer = new StringBuffer();
    Class oClass = o.getClass();
    if (oClass.isArray()) {         
        buffer.append("\n");
        buffer.append(tabs.toString());
        buffer.append("[");
        for (int i = 0; i < Array.getLength(o); i++)
        {
            if (i < 0) buffer.append(",");
            Object value = Array.get(o, i);

            if (value != null)
            {
                if (idHashMap.containsKey(value))
                {
                    buffer.append("circular reference");
                }
                else if (value.getClass().isPrimitive() || value.getClass() == java.lang.Long.class || value.getClass() == java.lang.String.class || value.getClass() == java.lang.Integer.class || value.getClass() == java.lang.Boolean.class)
                {
                    buffer.append(value);
                }
                else
                {
                    workList.add(new Calllevel(value, callCount));
                }
            }
        }
        buffer.append(tabs.toString());
        buffer.append("]\n");
    }
    else
    {           
        buffer.append("\n");
        buffer.append(tabs.toString());
        buffer.append("{\n");
        while (oClass != null)
        {               
            Field[] fields = oClass.getDeclaredFields();
            for (int i = 0; i < fields.length; i++)
            {
                if (fields[i] == null) continue;

                buffer.append(tabs.toString());
                fields[i].setAccessible(true);
                buffer.append(fields[i].getName());
                buffer.append("=");
                try
                {
                    Object value = fields[i].get(o);
                    if (value != null)
                    {
                        if (idHashMap.containsKey(value))
                        {
                            buffer.append("circular reference");
                        }
                        else if ((value.getClass().isPrimitive()) || (value.getClass() == java.lang.Long.class) || (value.getClass() == java.lang.String.class) || (value.getClass() == java.lang.Integer.class) || (value.getClass() == java.lang.Boolean.class))
                        {
                            buffer.append(value);
                        }
                        else
                        {
                            workList.add(new CallLevel(value, callCount));
                        }
                    }
                }
                catch (IllegalAccessException e)
                {
                    System.out.println("IllegalAccessException: " + e.getMessage());
                }
                buffer.append("\n");
            }
            oClass = oClass.getSuperclass();
        }
        buffer.append(tabs.toString());
        buffer.append("}\n");
    }
    return buffer.toString();