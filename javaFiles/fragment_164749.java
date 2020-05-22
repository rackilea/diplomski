List<String> srcList = Arrays.asList("Apple", "Banana", "Cherry");
var fruits = new ArrayList<>(srcList);
var unmodifiableList = Collections.unmodifiableList(fruits);     
fruits.set(0, "Apricot");
var modFruit = unmodifiableList.get(0);
System.out.println(modFruit); // prints Apricot