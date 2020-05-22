String[] input = new String[] {"a", "b", "a", "c", "a", "b", "d"};
String[] distinct = getDistinct(input);

for(String element : distinct) {
    System.out.println(element);
}