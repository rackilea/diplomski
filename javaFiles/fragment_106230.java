public String reverseString( String str )
{
    if(str.length()==1){
        return str;
    }
    return str.charAt( str.length() - 1 ) + reverseString( str.substring( 0, str.length() - 1 ) );

}
// initialize pos to 0
public int getLargest( int[] arr, int pos )
{
    int largest = arr[pos];
    if ( pos + 1 >= arr.length ) {
        return largest;
    }

    int second = getLargest( arr, pos + 1 );
    return largest > second ? largest : second;
}