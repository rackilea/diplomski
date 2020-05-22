abstract class Character
{
    private Item item;

    public Character (Item item)
    {
        this.item = item;
    }

    public <T extends Item> T getItem (Class <? extends T> targetType)
    {
        return targetType.cast(this.item);
    }

    public void setItem (Item item)
    {
        this.item = item;
    }
}

class Hero extends Character
{
    public Hero (Item item)
    {
        super (item);
    }

    public static void main(String[] args) {

        Hero hero1 = new Hero(new Weapon("sword"));
        Weapon weapon = hero1.getItem(Weapon.class);
        hero1.setItem(new Potion("syrup"));
        Potion potion = hero1.getItem(Potion.class);
    }
}