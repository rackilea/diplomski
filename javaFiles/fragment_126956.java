class Duck implements Comparable<Duck>
{
    private int height;
    [...]
    public int compareTo(Duck other)
    {
        return height - other.height;
    }
}