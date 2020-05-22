public static int binarySearch(Comparable[] objArray,Comparable item)
{       
    return bSearch(objArray, item, 0, objArray.length -1);
    ....

private static int bSearch(Comparable[] objArray,Comparable item, int lower, int upper)
{
   if( lower > upper /* not found */){ return -1; };

   int pivot = ((int)((upper - lower) / 2)) + lower;

   int cmp = objArray[pivot].compareTo(item);

   if( cmp == 0 ){ return pivot; }
   else if (cmp < 0 ){ return bSearch(objArray,item, lower, pivot - 1); }
   else{ return bSearch(objArray,item, pivot+1, upper); }
}