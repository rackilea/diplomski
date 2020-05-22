List<String> objects = Arrays.asList("one","two","three");
List<Double> chance = Arrays.asList(0.25, 0.25, 0.5);

// Build the tree map
TreeMap<Double, String>  map = new TreeMap<>();
double total = 0.0d;
for (int i = 0; i < objects.size(); i++) {
    map.put(total += chance.get(i), objects.get(i));
}
System.out.printf("The generated is map %s%n", map);

// The generator of random numbers
Random generator = new Random();
// Generate a random value between 0 and 1
double value = generator.nextDouble();
// Get the object that matches with the generated number
String object = map.ceilingEntry(value).getValue();
System.out.printf("The current value is %f corresponding to '%s'%n", value, object);