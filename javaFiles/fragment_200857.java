public class Warrior {
    private static final int DAMAGE_BONUS = //...

    public void attack() {
        this.setDamage(this.getDamage() + getBonus());
    }

    private int getBonus() {
        return DAMAGE_BONUS;
    }
}