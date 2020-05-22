String cArray[]={"AX","BY","CZ"};
    Map<String, Integer> map=new HashMap<String, Integer>();
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);
    String[] c1Array = cArray[0].split("(?!^)");//Will give you A
    String[] c2Array = cArray[1].split("(?!^)");//Will give you B
    int total = map.get(c1Array[0]) +  map.get(c2Array[0]);
    System.out.println(total);//Output: 3