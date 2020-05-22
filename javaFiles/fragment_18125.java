public class Player implements Comparable<Player>
{
    private String _name;
    private double _score;

    public Player(String name, double score)
    {
        this._name = name;
        this._score = score;
    }

    public String getName()
    {
        return this._name;
    }

    public double getScore()
    {
        return this._score;
    }

    // Since you probably want to sort the players in
    // descending order, I'm comparing otherScore to this._score.
    @Override
    public int compareTo(Player otherScore) 
    {
        return Double.compare(otherScore._score, this._score);
    }

    @Override
    public String toString()
    {
        return "Name: " + this._name + ", Score: " + Double.toString(this._score);
    }
}