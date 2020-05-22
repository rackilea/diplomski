public static void main(String[] args) {
        Map<Class<?>,List<?>> map = new HashMap<Class<?>,List<?>>();
        map.put(String.class, new ArrayList<String>());
        map.put(Integer.class, new ArrayList<Integer>());
        map.put(Class.class, new ArrayList<Class<?>>());

        String str = "deneme";

        @SuppressWarnings("unchecked")
        List<String> strList =  (List<String>) map.get(String.class);
        strList.add(str);
        strList.add("str2");
        strList.add("str2");

        @SuppressWarnings("unchecked")
        List<Class<?>> classList =  (List<Class<?>>) map.get(Class.class);
        classList.add(String.class);
        classList.add(Integer.class);
        classList.add(Double.class);


        for(String currentStr:strList){
            System.out.println(currentStr);
        }
    }