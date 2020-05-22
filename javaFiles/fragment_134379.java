public class Game {

   HashMap<String ,Team> teams = new LinkedHashMap<String ,Team>();


   public void addTeam(String teamName) {
      Team team =  new Team(teamName) ;
      teams.put(teamName ,team);
   }

   public void addPlayer(String teamName,String firstName,String lastName, int age ) {
       Player player = new Player(firstName,lastName, age);
       Team team = teams.get(teamName) ;
       team.addPlayer(player);
   }

   public void print(){
       for(Map.Entry<String , Team> entry : teams.entrySet() ) {
           Team team = entry.getValue();
           System.out.println("Team Name : " + team.getTeamName());
           System.out.println("Players : " + team.getPlayers().toString());
       }
   }

   public static void main (String args[]) throws Exception{

       Game game = new Game();

       game.addTeam("team1");
       game.addTeam("team2");

       game.addPlayer("team1","mehdi","ayari",20);
       game.addPlayer("team2","name1","name2",30);
       game.addPlayer("team2","name2","name3",40);

       game.print();

   }
}