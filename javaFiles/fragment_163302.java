System.out.print("Please enter the number of salespeople to be processed: ");
howmany = input.nextInt();

int[][] array = new int[2][howmany];//2D array to store the amount, and worth of the item


for (int i=0; i<howmany;i++  )
{
    System.out.print("Enter and ID number and Sales Amount seperated by a space: ");        
    array[0][i] = input.nextInt();
    array[1][i] = input.nextInt();
}

System.out.println("\n\t\t\t\tWeekly Sales by Salesperson");
int addwan=0;
for (int j = 0; j < howmany ; j++)
{

    System.out.println( "Eintrag: "+j+" number of sales: "+array[0][j]+" itemworth: "+array[1][j]);
    addwan+=array[0][j]*array[1][j];
}

System.out.println("\nTotal Sales: " + addwan + " ");