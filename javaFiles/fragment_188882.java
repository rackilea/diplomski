Map<Integer, Map<String, String>> mainCont = new HashMap<Integer, Map<String,String>>();

Map<String, String> content = new HashMap<String, String>();

content.put("1", "1");

mainCont.put(1, content);

System.out.println(mainCont);

content.clear();

System.out.println(mainCont);