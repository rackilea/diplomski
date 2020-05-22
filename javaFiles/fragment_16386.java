public static void main (String[] args)
{
    // Create a player
    player player = new player("Steve", 10, 10);
    // Initialise your values
    Values v = new Values();
    // create the enemies (this could be done in your values constructor)
    v.sValues();
    // Start with these enemies
    start(player, v.getEnemies());
}