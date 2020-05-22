List<Item> items = new ArrayList<Item>();
for (int i = 0; i < result.length; i+=3) {
   String value1 = result[i  ].split("=")[1];
   String value2 = result[i+1].split("=")[1];
   String value3 = result[i+2].split("=")[1];
   items.add(new Item(value1, value2, value3));
}