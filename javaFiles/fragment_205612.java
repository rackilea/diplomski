String garlic = "1 small garlic clove, finely grated on a microplane";
String[] queryArray = extract(garlic);
List<String> toAvoid = Arrays.asList("a", "to", "on");
for (int i = 0; i < queryArray.length; i++ ) {
    if (!toAvoid.contains(queryArray[i])) {
        performQuery(queryArray[i]);
    }
}