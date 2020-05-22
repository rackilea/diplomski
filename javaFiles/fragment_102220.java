public class Team{
    private int teamId;
    private static int teamIdCounter = 0;

    public Team(){
        this.teamId= teamIdCounter++;
    }
    public void printTeamId(){
        System.out.println(this.teamId);
    }
}