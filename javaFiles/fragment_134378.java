class Team {
   String teamName ;

   List<Player> players = new ArrayList<Player>() ; ;

   public Team(String teamName){
       this.teamName = teamName;
   }

   public void addPlayer(Player player) {
       players.add(player);
   }

   public String getTeamName(){
       return teamName;
   }

   public List<Player> getPlayers(){
       return  players ;
   }
}