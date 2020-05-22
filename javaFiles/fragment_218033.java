public static void main(String args[])
{
    Team team1 = new Team("parameters required here");
    Team team2 = new Team("parameters required here");   
    Playoff p = new Playoff();
    p.add(team1);
    p.add(team2);
    p.startPlayoffs();
}