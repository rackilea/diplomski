java.util.Collections.sort
(
    list,
    new java.util.Comparator<Map<String,String>>()
    {
        public int compare(Map<String,String> map1, Map<String,String> map2)
        {
            String firstName1 = map1.get("firstName");
            String firstName2 = map2.get("firstName");
            if(firstName1 == null)
                if(firstName2 == null)
                    return 0;
                else
                    return -1; // treat null as less than any non-null
            else
                if(firstName2 == null)
                    return 1; // treat null as less than any non-null
                else
                    return firstName1.compareTo(firstName2);
        }
    }
);