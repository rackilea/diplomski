int size = 12; //size of the multiplication table
for(int row = 1; row <= size; row++) //go row by row
{
    for(int col = 1; col <= size; col++) //go column by column
        if(size - col < row) //in the bottom right area
            System.out.printf("%5d", row * col); //print the number
        else
            System.out.print("     "); //print whitespace for formatting
    System.out.println(); //end of the row, go to the next line
}