public class Test
{
    public static void main(String[] args)
    {
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = 
            new PriorityQueue<String>(10, comparator);
        queue.add("file3");
        queue.add("file1");
        queue.add("file2");
        while (queue.size() != 0)
        {
            System.out.println(queue.remove());
        }
    }
}