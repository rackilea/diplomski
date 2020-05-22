Map<Integer, Integer> mapThatPretendsToBeAnArray = new LinkedHashMap<Integer, Integer>();
mapThatPretendsToBeAnArray.put(0, 17);
mapThatPretendsToBeAnArray.put(1, 5);
mapThatPretendsToBeAnArray.put(2, 1);
mapThatPretendsToBeAnArray.put(3, 319);

//someFunction()
for (int i = 0; i < mapThatPretendsToBeAnArray.get(1); i++) {
    System.out.print("#");
}
System.out.println("");

//someFunctionB()
mapThatPretendsToBeAnArray.put(3, "stringFinal".replaceAll("[^"+"sttr"+"]", "").length());