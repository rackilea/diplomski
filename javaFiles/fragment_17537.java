public class Unit { }

public class Infantry extends Unit {  }

public class DamageCalculator {

    public double calculateDamage(Unit unit, double damage) { 
        return damage; // presumably return unit.getStrength() * damage;
    }

}

public class Main {
    public static void main(String [] a) {
        Unit i = new Infantry();
        DamageCalculator damageCalculator = new DamageCalculator();
        double damage = 0.1;
        double result = damageCalculator.calculateDamage(i, damage);
    }
}