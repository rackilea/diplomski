public class Sorter{ public void sortList()
{
    Collections.sort(objList, comparator);

    // Now consume / print your objList to get sorted by date
}

ArrayList<Object>   objList     = new ArrayList<Object>();

Comparator<Object>  comparator  = new Comparator<Object>()
                                {



                                @Override
                                public int compare(Object object1, Object o2)
                                    {
                                        Date o1Date = getDateFromMethod(object1);
                                        Date o2Date = getDateFromMethod(o2);
                                        if (o1Date != null && o2Date != null)
                                        {
                                            if (o1Date.before(o2Date))
                                                return -1;
                                            else if (o1Date.after(o2Date))
                                                return 1;

                                            else
                                                return 0;
                                        }
                                        else
                                            return -1;
                                    }
                                };

public Date getDateFromMethod(Object obj)
{

    Date date = null;
    String getDate = "getDate";
    try
    {
        Method method = obj.getClass().getMethod(getDate, (Class<?>[]) null);
        if (method != null)
            date = (Date) method.invoke(obj, (Object[]) null);
    }
    catch (NoSuchMethodException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (SecurityException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (IllegalAccessException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (IllegalArgumentException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (InvocationTargetException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return date;
}public Date getDateFromProperty(Object obj)
                            {
                                Date date=null;
                                try
                                {
                                Field dateField=    obj.getClass().getField("date");
                                if(dateField!=null)
                                    date=(Date) dateField.get(obj);
                                }
                                catch (NoSuchFieldException e)
                                {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                catch (SecurityException e)
                                {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                catch (IllegalArgumentException e)
                                {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                catch (IllegalAccessException e)
                                {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                                return date;

                            }