public int hashCode()
{
    int rankHash = ((rank == null) ? 0 : (1+rank.ordinal()));
    int suitHash = ((suit == null) ? 0 : (1+suit.ordinal()));
    return rankHash + 31*suitHash;
}