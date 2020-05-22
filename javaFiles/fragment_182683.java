public static void main(String[] args)
{
    Scanner in = new Scanner (System.in);
    System.out.print("Enter a number between 0 and 511: ");
    int n = in.nextInt();

    String binary = Integer.toBinaryString(n);
    binary = binary.format("%09d", Integer.parseInt(binary));
    System.out.println(binary);

    int result[][]=new int[3][3];
    int position=0;
    for (int i = 0; i < result.length; i++)
    {
        for (int j = 0; j < result.length; j++)
        {
            result[i][j]=binary.charAt(position++)-'0';
            System.out.print(result[i][j]+" ");
        }
        System.out.println();
    }


}