List<Map<String,List<String>>> list = new ArrayList<Map<String,List<String>>>();//This is the final list you need
Map<String, List<String>> map1 = new HashMap<String, List<String>>();//This is one instance of the  map you want to store in the above list.
List<String> arraylist1 = new ArrayList<String>();
arraylist1.add("Text1");//And so on..
map1.put("key1",arraylist1);
//And so on...
list.add(map1);//In this way you can add.