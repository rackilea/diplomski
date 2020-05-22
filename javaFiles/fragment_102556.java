int total = 0;
for( int y = 0; y < numbers.length; y++ )
{ 
   total += fibonacci[y];

   System.out.println( numbers[y] + "\t" + fibonacci[y] 
                                + "\t" + "\t" + "\t" + total );
}

total -= fibonacci[0] + fibonacci[numbers.length-1];