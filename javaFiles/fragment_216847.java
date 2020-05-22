interface GameObject {}
class WeaponAttribute {}
interface Weapon extends GameObject {
    Number attack();
    boolean addWeaponAttribute(WeaponAttribute attribute);
}
interface Firearm extends Weapon {
    void reload(Number rounds);
}
class WeaponBaseClass implements Weapon {
    WeaponBaseClass(WeaponName weaponName) {
        this.weaponName=weaponName;
    }
    @Override public Number attack() {
        return null;
    }
    @Override public boolean addWeaponAttribute(WeaponAttribute attribute) {
        return false;
    }
    public String toString() {
        return weaponName.toString();
    }
    final WeaponName weaponName;
}
class FirearmBaseClass extends WeaponBaseClass implements Firearm {
    public FirearmBaseClass(WeaponName weaponName) {
        super(weaponName);
    }
    @Override public void reload(Number rounds) {}
}
enum WeaponName {
    knife, sword, colt45, glock19, glock19WithLaser;
}
class WeaponCreator {
    Weapon create(WeaponName weaponName) {
        switch (weaponName) {
            case knife:
            case sword:
                return new WeaponBaseClass(weaponName);
            case colt45:
            case glock19:
                return new FirearmBaseClass(weaponName);
            default:
                return new WeaponBaseClass(weaponName);
        }
    }
}
class FancyWeaponCreator extends WeaponCreator {
    Weapon create(WeaponName weaponName) {
        Weapon weapon = null;
        switch (weaponName) {
            case glock19WithLaser:
                weapon = super.create(WeaponName.glock19);
                // whatever it needs
                return weapon;
            default:
                return new WeaponBaseClass(weaponName);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(new WeaponCreator().create(WeaponName.knife));
        System.out.println(new WeaponCreator().create(WeaponName.colt45));
        System.out.println(new FancyWeaponCreator().create(WeaponName.glock19WithLaser));
    }
}