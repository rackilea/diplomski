package stackoverflow.fight;

/**
 * modelling the Fighters
 */
public class Opponent {

private final String name;
private final int maxHitpoints;
private int currentHitpoints;
private Weapon weapon;
private final boolean isMonster;
private int currentMoney;

/**
 * init the fighter
 * 
 * @param name
 * @param maxHitpoints
 *            - starting hitpoints
 * @param isMonster
 *            - true for monster, false for goodman
 */
public Opponent(String name, int maxHitpoints, boolean isMonster) {
    super();
    this.name = name;
    this.maxHitpoints = maxHitpoints;
    this.isMonster = isMonster;
    this.currentHitpoints = this.maxHitpoints; // currentHitpoints will
                                                // decrease with hit

    // Goodman starts with BAT, MOnster uses Claws
    weapon = isMonster ? Weapon.CLAWS : Weapon.BAT;

    // Monster has no money, Goodman starts with 10
    currentMoney = isMonster ? 0 : 10;
}

/**
 * @return the weapon the fighter uses
 */
public Weapon getWeapon() {
    return weapon;
}

/**
 * @param weapon
 */
public void setWeapon(Weapon weapon) {
    if (this.weapon == weapon) {
        return;
    }

    this.weapon = weapon;
    this.currentMoney -= weapon.getCost();

    System.out.println("\t" + name + " bought new weapon " + weapon.getName() + ". Money left: " + currentMoney);
}

/**
 * @return name of the fighter
 */
public String getName() {
    return name;
}

/**
 * @return actual state
 */
public int getCurrentHitpoints() {
    return currentHitpoints;
}



/**
 * runs an attack with current weapon on the opponent
 * 
 * @param opponent
 * @return the damage done
 */
public void attack(Opponent opponent) {
    // one can only attack while he's not dead! (giving an advantage to the first striker)
    if (isAlive()) {
        // calculate the damage
        int damage = weapon.rollDamage();

        opponent.wound(damage);
        // output the dramatic scene
        System.out.println("\t" + name + " attacks " + opponent.getName() + " with " + weapon.getName() 
                + " and deals " + damage + " points of damage, leaving " + opponent.getCurrentHitpoints());
    } else {
        System.out.println("\t" + name + " would strike but unfortunately died trying!");
    }
}

/**
 * reduce currentHitpoints by damage
 * 
 * @param damage
 */
public void wound(int damage) {
    currentHitpoints -= damage;
}

/**
 * @return true if the fighter still has more than 0 hitpoints
 */
public boolean isAlive() {
    return currentHitpoints > 0;
}

/**
 * recover hitpoints (to a max of maxHitpoints
 * @param hitPoints
 */
public void recover(int hitPoints) {
    currentHitpoints += hitPoints;

    // dont go over maximum
    if (currentHitpoints > maxHitpoints) {
        currentHitpoints = maxHitpoints;
    }
    // message
    System.out.println("\t" + name + " recovers " + hitPoints + " to a current of " + currentHitpoints);
}

/**
 * @return is this a monster?
 */
public boolean isMonster() {
    return isMonster;
}

/**
 * @return how much money is left?
 */
public int getCurrentMoney() {
    return currentMoney;
}
}