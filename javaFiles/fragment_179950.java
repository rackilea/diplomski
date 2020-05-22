// This is fine
Map<String, ? super Apple> map = getMapFromSomewhere();
map.put("Foo", new Apple());

// This isn't - it might be a Map<String, Orange>!
Map<String, ? extends Fruit> map = getMapFromSomewhere();
map.put("Foo", new Apple());