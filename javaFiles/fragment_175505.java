List<Banana> allBananas = getMyBananas();
enumerateMyFruit(allBananas);

static void enumerateMyFruit(List<? extends Fruit> myFruit) {
    for (Fruit fruit : myFruit)
        System.out.println(fruit);
}