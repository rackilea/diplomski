for ( int col = 0; col < longestRow; col++)
{
   int highest = Integer.MIN_VALUE;
   for ( int row = 0; row < num.length; row++)
        if ( col < num[row].length && num[row][col] > highest) 
            highest = num[row][col];
    System.out.println( "Highest number in column " + col + " = " + highest);
}