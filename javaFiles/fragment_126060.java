public class InventoryManager {

    public enum InventoryItem {
        LIGHT("Flashlight") {
            boolean isOn;
            @Override public void doAction() {
                isOn = !isOn;
            }
            @Override public String toString() {
                return name;
            }
        },
        POTION("Health Potions") {
            @Override public void doAction() {
                Game.getPlayer().setHealth(Game.getPlayer().getHealth() + 25);
                remove(1);
            }
        },
        SNACK("Snacks") {
            @Override public void doAction() {
                Game.getPlayer().setEnergy(Game.getPlayer().getEnergy() + 10);
                remove(1);
            }
        };

        private final String name;
        private int quantity = 0;

        private InventoryItem(String n) {
            name = n;
        }

        public abstract void doAction();

        public void add(int q) {
            if ((quantity += q) < 0) quantity = 0;
        }

        public void remove(int q) {
            add(-q);
        }

        @Override public String toString() {
            return name + " x" + quantity;
        }
    }

    public static InventoryItem[] getHeldItems() {
        EnumSet<InventoryItem> items = EnumSet.allOf(InventoryItem.class);

        Iterator<InventoryItem> it = items.iterator();
        while (it.hasNext()) {
            if (it.next().quantity < 1) {
                it.remove();
            }
        }

        return items.toArray(new InventoryItem[items.size()]);
    }
}