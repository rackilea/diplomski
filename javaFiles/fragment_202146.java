class Freezer extends StoreageChest<Freezeable> { }

class MiniFoodFreezer {

    private final Freezer freezer = new Freezer();

    public <T extends Freezeable & Edible & SmallerThanABeachball> void add(
            final T toStore
    ) {
        freezer.add(toStore);
    }
}