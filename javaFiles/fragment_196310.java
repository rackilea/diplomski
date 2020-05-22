public class ScoreBoard {
List<ScoreCard> board;
public ScoreBoard(String tourneyName)
{    
    this.tournament = tourneyName;
    this.board = new ArrayList<ScoreCard>(); 
}