// NOTE: changed return type to void -- this is a side-effect-only method!
public void Encrypt(char Encrypt[][])
{
    // NOTE: use single-quotes for chars. double-quotes are for strings.
    char aChar = 'A';
    // NOTE: changed the starting loop values from `1` to `0`
    for (int row = 0; row < Encrypt.length; row++)
    {
        // NOTE: technically Encrypt.length works here since it's a square
        // 2D array, but you should really loop until Encrypt[row].length
        for (int column = 0; column < Encrypt[row].length; column++)
        {
            // NOTE: set each entry to the desired char value
            Encrypt[row][column] = aChar;
        }
    }   
}