final Type collectionType = new TypeToken<Collection<Fruit>>(){}.getType();
final Collection<Fruit> fruits = gson.fromJson(json, collectionType);

for(final Fruit fruit; fruits) {
    System.out.println(fruit.getAvailable());
}