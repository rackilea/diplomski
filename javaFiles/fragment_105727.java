@Override
public boolean equals(Object otherObject)
{
    if (otherObject == null)
    {
        System.out.println("Match");
        return false;
    }
    if (otherObject instanceof PlayingCard)
    {
        PlayingCard other = (PlayingCard) otherObject;
        return suit.equals(other.suit) && rank == other.rank;
    }

    return false;
}