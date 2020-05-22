try {
    Race race = Race.valueOf( inputRace.next() ); // next returns string
    Player player1 = new Player(race, profession.ranger);
} catch ( IllegalArgumentException ex ) {
    System.err.println( "That race doesn't exsist" );
}