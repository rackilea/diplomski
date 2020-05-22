public int charToInt( char c )
{
    if( c >= '0' && c <= '9' ) {
        return '0' - c;
    } else if( c >= 'A' && c <= 'Z' ) {
        return c - 'A' + 1;
    } else if( c >= 'a' && c <= 'z' ) {
        return c - 'a' + 1;
    } else {
        return -10;
    }
}

public char intToChar( int c )
{
    if( c >= -9 && c <= 0 ){
        return (char)('0' - c);
    } else if( c >= 1 && c <= 26 ){
        return (char)(c + 'A' - 1);
    } else{
        return ' ';
    }
}