int targetIndex = 0;
for( int sourceIndex = 0;  sourceIndex < array.length;  sourceIndex++ )
{
    if( array[sourceIndex] != 0 )
        array[targetIndex++] = array[sourceIndex];
}
int[] newArray = new int[targetIndex];
System.arraycopy( array, 0, newArray, 0, targetIndex );
return newArray;