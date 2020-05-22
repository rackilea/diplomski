public static int getSum( int a, int b ) { 
 if ( a == b ) { // if both are equal there are no numbers in between - so sum is number itself.
     return a;
 }
 // if a < b then increment a to reach b otherwise increment b to reach a.
 // this works even if a or b or both are negative.
 // So when you increment a, add 'a' only to current sum and then move forward
 // When you increment b, add 'b' only to current sum and then move forward.
 return a < b ?  a + getSum( a + 1, b ) :  b + getSum( a, b + 1 );    
}