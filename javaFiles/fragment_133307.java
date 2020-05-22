public static void main (String [] args)
{
    String myString = "hello there";
    int length = myString.length();
    int ascii;
    char character;
    int[] myarray = new int[256];
    for(int i =0; i < length; i++)
    {
        character = myString.charAt(i);
        ascii = character; // casting the character into an int
        // not optimal, but works
        System.out.println(String.format("%7s", Integer.toBinaryString(ascii)).replace(' ', '0'));

        myarray[ascii]++; // counting the frequency of each letter in the string

    }
    System.out.println();

    for ( int k = 0; k < myarray.length; k++ )
    {
        if ( myarray[k] > 0 ) // if the frequency is greater than 0 do this print line, without this programm would print all 255 ascii characters.
        {
            System.out.println("'"+(char)k + "'" + " appeared " +    myarray[k]      + " times." );
        }
    }
}