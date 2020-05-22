public abstract class AbstractHero implements Hero {
    protected Weapon weapon;

    public void killOrBeKilled() {
        weapon.secretWeaponManeuver();
    }

    protected abstract void setWeapon(Weapon weapon);
}