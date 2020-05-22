abstract class Item {
    public abstract void useItem();
}

class PickUpHealth extends Item  {
    private int healAmount;
    public PickUpHealth(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void useItem() {
        player.addHealth(healAmount);
    }
}

public static void main(String[] args) {
    List<Item> items = Arrays.asList(new PickUpHealth(10));
    Item item = items.get(0);
    item.useItem();
}