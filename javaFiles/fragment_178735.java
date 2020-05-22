do
{
    if((char) nextChar == '.')
        reachedDot = true;

    integer += (char) nextChar;
    readChar();
} while (reachedDot ? Character.isDigit(nextChar) : ((Character.isDigit(nextChar) || nextChar == '.'));