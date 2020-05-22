ListMarshaller<ReusableUuid> valueMarshaller = ListMarshaller.of(
     ReusableUuidReader.INSTANCE, ReusableUuidWriter.INSTANCE);
List<ReusableUuid> averageValue = Stream
    .generate(() -> ReusableUuid.random())
    .limit(averagePizzasForTopping)
    .collect(Collectors.toList());
 ChronicleMap<Topping, List<ReusableUuid>> map = ChronicleMap
     .of(Topping.class, (Class<List<ReusableUuid>>) (Class) List.class)
     .averageKey(pepperoni)
     .valueMarshaller(valueMarshaller)
     .averageValue(averageValue)
     .entries(numberOfToppings)
     .createPersistedTo(new File("toppings_to_pizza_ids.dat"));