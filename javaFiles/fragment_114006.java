public class MyInteger implements Comparable<MyInteger>
{
    public int  value;

    public MyInteger(int value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return Integer.toString(value);
    }

    @Override
    public int compareTo(MyInteger o)
    {
        return value - o.value;
    }
}