List<Banana> bananas = new ArrayList<Banana>();
// This is fine, right?
List<? extends Fruit> fruit = bananas;

// We don't want to be able to add an apple to a list of bananas!
fruit.add(new Apple());

// ... as otherwise this is no longer safe
Banana bananas = bananas.get(0);