private int smallest = Integer.MAX_VALUE;
private int largest = Integer.MIN_VALUE;

public void addValue(int x)
{
    smallest = Math.min(smallest, x);
    largest = Math.max(largest, x);
    sum = sum + x;
    count++;
}