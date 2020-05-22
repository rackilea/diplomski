public static void main(String... args)
{
    System.out.println(calculateMean(getData()));
}

public static int[] getData()
{
    data = new int[5];
    Scanner s = new Scanner(System.in);

    for (int i = 0; i < data.length; i++)
    {
        System.out.print("Enter score number " + (i++) + ": ");
        data[i] = Integer.parseInt(s.nextLine());
    }
    s.close();
    return data;
}

public static double calculateMean(int[] data)
{

    int s = 0;
    for (int i = 0; i < data.length; i++)
    {
        s += data[i];
    }
    return mean = (double) s / (data.length);
}