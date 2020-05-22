public class Sum implements Comparable<Sum>
{
    private int sumTotal;
    private int evenCount;
    private int oddCount;

    public void addNumber(int n)
    {
        sumTotal += n;
        if ((n & 0x1) == 0x1)
        {
            oddCount++;
        }
        else
        {
            evenCount++;
        }
    }

    @Override
    public int compareTo(Sum other)
    {
        return Integer.compare(sumTotal, other.sumTotal);
    }

    @Override
    public String toString()
    {
        return String.format("%-10s%-10s%-10s", sumTotal, evenCount, oddCount);
    }

}