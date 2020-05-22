public static void main(String[] args) throws Exception {
   Map<String, String> myMap = new TreeMap<>();
   myMap.put("a","1");
   myMap.put("b","2");
   myMap.put("c","3");
   Collection<String> values = myMap.values();
   List<String> val = new ArrayList(values);
   System.out.println(val);  
}