package stackoverflow.fight;

/**
 * implements the neverending fight between good and evil
 */
public class Fight {

private int roundCount = 1;

private final Opponent opponentOne;
private final Opponent opponentTwo;

/**
 * set up the fight between Opponents One and Two
 * 
 * @param opponentOne
 * @param opponentTwo
 */
public Fight(Opponent opponentOne, Opponent opponentTwo) {
    super();
    this.opponentOne = opponentOne;
    this.opponentTwo = opponentTwo;
}

/**
 * @return the fight is active while both opponents are alive
 */
public boolean isOngoing() {
    return opponentOne.isAlive() && opponentTwo.isAlive();
}

/**
 * perform the attack
 * 
 * @param a
 * @param b
 */
private void attack(Opponent a, Opponent b) {
    a.attack(b);
}

private void roundBasedSuccess() {
    // if Goodman survives round 2 print a message of encouragement
    if (opponentOne.isAlive() && roundCount == 2) {
        System.out
                .print("\tThis is encouraging. Goodman has lasted past round 2!");
        return;
    }

    // every 3 rounds, opponentA gains hitPoints
    if (opponentOne.isAlive() && roundCount % 3 == 0) {
        System.out
                .print("\tGoodman is as strong as Samson. He has lasted round "
                        + roundCount + " and still looks strong.");
        opponentOne.recover(10);
    }
}

/**
 * Command.F: Fight
 */
public void fight() {
    roundBasedSuccess();

    // who attacks first (0 or 1)
    switch (Double.valueOf(Math.random() * 2).intValue()) {
    case 0:
        System.out
                .println("\t" + opponentOne.getName() + " strikes first.");
        attack(opponentOne, opponentTwo);
        attack(opponentTwo, opponentOne);
        break;
    case 1:
        System.out.println("\t " + opponentTwo.getName()
                + " strikes first.");
        attack(opponentTwo, opponentOne);
        attack(opponentOne, opponentTwo);
        break;

    }

    // print message if still in the game
    if (opponentOne.isAlive()) {
        System.out.println("\t" + opponentOne.getName() + " has "
                + opponentOne.getCurrentHitpoints()
                + " points left. Not bad, Man! ");
    }

    if (opponentTwo.isAlive()) {
        System.out.println("\tWait, " + opponentTwo.getName()
                + " has a total of " + opponentTwo.getCurrentHitpoints()
                + " points and is still in the game");
    }

    System.out.println("This is the end of round " + roundCount++ + " "); // increase
                                                                            // roundCount
}

/**
 * Command.R: rest
 */
public void rest() {
    System.out.println("r: Opponents should rest (regaining 2 hitpoints");
    opponentOne.recover(2);
    opponentTwo.recover(2);
}

/**
 * Command.C: Status
 */
public void status() {
    System.out.println("\tChecking the status of the game: Round "
            + getRoundCount() + ": " + opponentOne.getName() + " has "
            + opponentOne.getCurrentHitpoints() + " points and "
            + opponentTwo.getName() + " has "
            + opponentTwo.getCurrentHitpoints() + " points\n");
}

/**
 * @return actual number of rounds
 */
public int getRoundCount() {
    return roundCount;
}

/**
 * @return title of the fight (A vs. B)
 */
public String getTitle() {
    return opponentOne.getName() + " vs. " + opponentTwo.getName()
            + " - Round " + roundCount + ": ";
}

/**
 * what happens if the fight is over
 */
public void end() {
    if (isOngoing()) {
        return; // Oops ... still alive
    }

    // opponentOne lost?
    if (!opponentOne.isAlive()) {
        System.out.println("\t" + opponentOne.getName()
                + "  you are out of the game! " + opponentTwo.getName()
                + " will take over the village. This is sad!");
        System.out.println("Game Over!");
    } else if (!opponentTwo.isAlive()) {
        System.out.println("\t" + opponentOne.getName()
                + " has been victorious");
        System.out.println("\t" + opponentTwo.getName()
                + " is dead. The people live!!!!");
        System.out.println("Game Over!");
    }

}

/**
 * Non-Monsters may switch weapons!
 * 
 * @param opponent
 * @param weapon
 */
public void buy(Opponent opponent, Weapon weapon) {
    if (opponent.isMonster()) {
        System.out.println("\tMonsters cannot buy weapons!");
        return;
    }

    // too expensive
    if (opponent.getCurrentMoney() < weapon.getCost()) {
        System.out.println("\t" + opponent.getName() + " has only " + opponent.getCurrentMoney() + " left. " + weapon.getName() + " costs " + weapon.getCost() + "!");
        return;
    }

    opponent.setWeapon(weapon);
}
    }