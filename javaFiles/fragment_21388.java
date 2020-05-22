public enum InventoryItem
{
    PICKAXE("Pickaxe", "Can be used to mine with", ItemType.Tool,
            5, 2, 0)

    EPIC_PICKAXE("Super mega awesome Pickaxe", "Can be used to mine with, but epically", ItemType.Tool,
            1000000, 100, 0)


    public static enum ItemType {
        TOOL,
        WEAPON
    }

    public final String name, description;
    public final ItemType type;
    public final boolean canSell, canEat, canEquip;
    public final int earnedCoins, attackAdd, defenseAdd;

    private InventoryItem(String name, String description, ItemType type
                          int earnedCoins, int attackAdd, int defenseAdd,
                          boolean canSell, boolean canEat, boolean canEquip)
    {
        this.name        = name;
        this.description = description;
        this.type        = type
        this.canSell     = canSell;
        this.canEat      = canEat;
        this.canEquip    = canEquip;
        this.earnedCoins = earnedCoins;
    }

    private InventoryItem(String name, String description, ItemType type
                          int earnedCoins, int attackAdd, int defenseAdd)
    {
        this(name, description, type,
             earnedCoins, attackAdd, defenseAdd,
             true, false, true);
    }
}