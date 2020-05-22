String[] players = {"PLYR1", "PLYR2", "PLYR3"}

for (String player: players) {
  try{
      team.addPlayer( new Player( 1, player ) );
  } catch ( Exception e ){
       System.out.println( e.toString() );
  }
}