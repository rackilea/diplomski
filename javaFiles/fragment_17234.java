if ( A[i] > secondLargest )
{
   if ( A[i] > largest )
     secondLargest = largest,
     largest = A[i];
   else
     secondLargest = A[i];
}