public static void main(String[] args)
{
    System.out.print("Counting");
    StringBuffer buffer = new StringBuffer();
    for (int i=0; i<28504; i++)
    {
        buffer.append("*");
    }
    System.out.print(" some more");
    System.out.println(buffer);
    System.out.println("Complete");
}