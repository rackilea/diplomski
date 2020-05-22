Set<String> animals = new HashSet<String>(
                          Arrays.asList("cat", "dog", "squirrel", "raccoon"));
if (animals.contains("dog")) {
    System.out.println("Yep, dog's here!"); // prints
}
if (!animals.contains("aardvark")) {
    System.out.println("Ah, aardvark's missing!"); // prints
}