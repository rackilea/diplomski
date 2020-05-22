package stackoverflow.fight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Modeling the available weapons
 */
public enum Weapon {

BAT("Bat", 2, 4, 3), //
AXE("Axe", 4, 6, 6), //
SWORD("Sword", 6, 8, 10), //
CLAWS("Claws", 2, 15, -1), // cost=-1 indicating: not buyable!
;

private final String name;
private final int minDamage;
private final int maxDamage;
private final int cost;


private Weapon(String name, int minDamage, int maxDamage, int cost) {
    this.name = name;
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
    this.cost = cost;

}


public String getName() {
    return name;
}

public int getMinDamage() {
    return minDamage;
}

public int getMaxDamage() {
    return maxDamage;
}

public int getCost() {
    return cost;
}

/**
 * @return calculates the number of damage dealt with weapon
 */
public int rollDamage() {
    return getMinDamage()
            + Double.valueOf(
                    Math.random()
                            * (getMaxDamage() - getMinDamage())).intValue();
}

public static Weapon findByName(String name) {
    for (Weapon weapon : getBuyableWeapons()) {
        if (weapon.getName().equalsIgnoreCase(name)) {
            return weapon;

        }
    }
    return null;
}

public static Set<Weapon> getBuyableWeapons() {
    Set<Weapon> buyableWeapons = new HashSet<Weapon>();

    for (Weapon weapon : Weapon.values()) {
        if (weapon.buyable()) {
            buyableWeapons.add(weapon);
        }
    }

    return buyableWeapons;
}

public boolean buyable() {
    return cost > 0;
}

public String toString() {
    return name + ", min:"+minDamage +", max:"+ maxDamage + ", cost:"+cost;
}

}