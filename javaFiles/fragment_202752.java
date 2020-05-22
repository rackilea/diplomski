public interface Weapon {
    void secretWeaponManeuver();
}

@BowType    
@Component
public class Bow implements Weapon {
    public void secretWeaponManeuver() {
        System.out.println("Bow goes Slinnnggggg!");    
    }
}

@SwordType
@Component
public class Sword implements Weapon {
    public void secretWeaponManeuver() {
        System.out.println("Sword goes Slassshhhh!");   
    }
}