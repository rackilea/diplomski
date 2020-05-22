// or Item can be an interface classes implement

public abstract class Item {
    public void doAction() {
        Game.updateState();
    }
}

public class Light extends InventoryItem {
    boolean lighted;
    @Override public void doAction() {
        lighted = !lighted;
        super.doAction();
    }
}

public class Potion extends InventoryItem {
    @Override public void doAction() {
        player.hp++;
        super.doAction();
    }
}

public class Snack extends InventoryItem {
    @Override public void doAction() {
        player.energy++;
        super.doAction();
    }
}