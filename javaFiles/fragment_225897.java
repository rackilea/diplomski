Map<String, Integer> myMap = new HashMap<String, Integer>();
String s = "SALES:0,SALE_PRODUCTS:1,EXPENSES:2,EXPENSES_ITEMS:3";
String[] pairs = s.split(",");
for (int i=0;i<pairs.length;i++) {
    String pair = pairs[i];
    String[] keyValue = pair.split(":");
    myMap.put(keyValue[0], Integer.valueOf(keyValue[1]));
}