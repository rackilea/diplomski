List<String> stringList = Arrays.asList("hello", "world");
System.out.println(stringList);
for (String currentString : stringList) {
    //naively trying to change the contents from ["hello", "world"] to ["bye", "world"]
    if (currentString.equals("hello")) {
        currentString = "bye";
    }
}
System.out.println(stringList);