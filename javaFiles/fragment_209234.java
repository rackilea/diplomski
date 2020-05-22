public static void sellSeatByPrice(int seatingChart[][])
{
   System.out.print("Please enter a price for the seat you would like: ");
   int price = in.nextInt();
   // boolean found = false;
   out: for (int i=0;i<9;i++)
     for (int j=0;j<10;j++)
        if (seatingChart[i][j]==price)
        { seatingChart[i][j]=0; break out; } // Notice this change

    printSeats(seatingChart);


}