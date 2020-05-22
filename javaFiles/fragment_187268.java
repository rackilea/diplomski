public class Game 
{ 

    private String name; public String getName() { return name; }
    private int score; public int getScore() { return score; }
    private int minutesPlayed; public int getMinutesPlayed() { return minutesPlayed; } 

    public Game(String name, int score, int minutesPlayed)
    {
        this.name = name;
        this.score = score;
        this.minutesPlayed = minutesPlayed
    }

    @Override
    public String toString()
    {
        return "Game: " + name + ", score= " + score + ", minutes played= " + minutesPlayed);
    }
}