public static void main(String[] argv)
throws Exception
{
    List<Object> fixedData = consumeAvailableMemory();
    while (true)
    {
        Object data = new byte[64 * 1024 - 1];
    }
}


private static List<Object> consumeAvailableMemory()
throws Exception
{
    LinkedList<Object> holder = new LinkedList<Object>();
    while (true)
    {
        try
        {
            holder.add(new byte[128 * 1024]);
        }
        catch (OutOfMemoryError ex)
        {
            holder.removeLast();
            return holder;
        }
    }
}