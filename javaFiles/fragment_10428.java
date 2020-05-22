public class Entry implements Comparable<Entry>    // Pick a more descriptive name
{
    int firstNumber;
    int month;
    int day;
    int lastNumber;

    public int compareTo(Entry other)
    {
        int comparison = month - other.month;
        if (comparison == 0)
            comparison = day - other.day;
        return comparison;
    }
}