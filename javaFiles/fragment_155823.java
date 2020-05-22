public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    String[]repName = new String[5];
    double[]salesAmount = new double[5];
    System.out.println("Please Enter Sales Reps Name Followed By Monthly Sales: \n");
    for (int i = 0  ; i < repName.length; i++ )
    {
        System.out.print("Sales Rep (Full Name):  "  );
        repName[i] = input.nextLine();

        System.out.print("Monthly Sales:  € "  );

        salesAmount[i] = input.nextDouble();
        input.nextLine();
        System.out.println();
    }
}