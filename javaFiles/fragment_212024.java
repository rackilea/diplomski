public static void main(String[] args)
    {

        Map map1 = new TreeMap();

        map1.put("String1", true);

        map1.put("String2", true);

        Map map2 = new TreeMap();

        map2.put("String1", false);

        map2.put("String2", false);

        Set keys = map1.keySet();
        boolean stop = true;
        for (Iterator i = keys.iterator(); i.hasNext();)
        {
            String key = (String) i.next();
            boolean value1 = (boolean) map1.get(key);
            boolean value2 = (boolean) map2.get(key);

            if (value1 == value2)
            {
                stop = false;
                break;
            }
        }

        if (stop)
            System.out.println("All values are different");
    }