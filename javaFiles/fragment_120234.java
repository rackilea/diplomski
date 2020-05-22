private static void showCommonValueKeys(HashMap<String, Integer> map1,HashMap<String, Integer> map2){
    Map<Integer,List<String>> map1Collect = flipKeyValue(map1);
    Map<Integer,List<String>> map2Collect = flipKeyValue(map2);

    for(Map.Entry<Integer,List<String>> m : map1Collect.entrySet()){
        int key = m.getKey();
        if(map2Collect.containsKey(key)){
            System.out.println("For value " + key);
            System.out.println("First map keys: " + m.getValue().toString());
            System.out.println("Second map keys: " + map2Collect.get(key).toString());
            System.out.println();
        }
    }

}

private static  Map<Integer,List<String>> flipKeyValue(HashMap<String, Integer> map){
     Map<Integer,List<String>> mapCollect = new HashMap<>(); 

     for(Map.Entry<String,Integer> m : map.entrySet()){
        String  key = m.getKey();
        int val = m.getValue();
        mapCollect.putIfAbsent(val,new ArrayList<>());
        mapCollect.get(val).add(key);
     }

     return mapCollect;
}