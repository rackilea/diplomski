public void attack1(Player p1, Player p2) { // first method in which player 2 attacks player 1
    Random rnd = new Random(); // instantiation of new random object
    int dmg = rnd.nextInt(26) - 1; // setting of variable dmg to = a random number between 0 and 25
    if (dmg >= 0 && dmg <= 15) { // if statement checking if dmg is between 0 and 15
        p1.health = p1.health - dmg; // if dmg is between 0 and 15, reduce value from player 1 health
        System.out.printf("%s attacked %s and %s's health is now %d.", p2.name, p1.name, p1.name, p1.health); // print to screen results of attack1
    } else if (dmg > 15) { // if dmg value is greater than 15, player 2 misses player 1
        System.out.printf("%s attacked %s and missed.", p2.name, p1.name); // print to screen results of missed attack1
    }