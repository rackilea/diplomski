public static void main(String[] args){
    List<LinkedHashMap<String,String>> list = new ArrayList<LinkedHashMap<String, String>>();

    LinkedHashMap<String, String> test = new LinkedHashMap<String, String>();
        test.put("a","1");
        test.put("b","2");

    list.add(test);

    for(Map<String, String> map : list){
        for(String key : map.keySet()){
            System.out.println("key: " + key + " value " + map.get(key));
        }
    }

}