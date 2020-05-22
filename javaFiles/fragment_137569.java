public class NormalStatus implements HealthStatus{
    double considerAttack(Attack anAttack){
        return anAttack.doAttack(); // No change here
    }
}

public class FrozenStatus implements HealthStatus{
    double considerAttack(Attack anAttack){
        return 0; // Can't attack when froxen
    }
}

public class BurnedStatus implements HealthStatus{
    double considerAttack(Attack anAttack){
        return anAttack.doAttack() * 2.0; // Get berserk when on fire!
    }
}