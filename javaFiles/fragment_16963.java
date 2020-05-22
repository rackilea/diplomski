class Item
{
    // Your string. It's public, so you can get it if you want,
    // but also final, so you can't accidentally change it.
    public final String string;

    // An array of counts, where the offset is the alphabetical position
    // of the letter it's counting. (A = 0, B = 1, C=2...)
    private final short[] instanceCounts = new short[32];

    public Item(String string)
    {
        this.string = string;
        for(char c : string.toCharArray())
        {
            // Increment the count for this character
            instanceCounts[(byte)c - 65] ++;
        }
    }

    public int getCount(char c)
    {
        return instanceCounts[(byte)c - 65];
    }
}