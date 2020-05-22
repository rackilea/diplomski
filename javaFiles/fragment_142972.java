String str = "00122334455667788990875645346787659870984780";
List<String> list = new ArrayList<String>();
for (int i = 0; i < str.length(); i += 2) {
    list.add(str.substring(i, i + 2));
} 
System.out.println(list);