public class FireAttack implements Attack {
    double doAttack(double baseDamage){
        return 1.1 * baseDamage;
    }
}

public class IceAttack implements Attack {
    double doAttack(double baseDamage){
        return 2 * baseDamage;
    }
}