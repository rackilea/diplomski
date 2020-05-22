do
{
    if((char) nextChar == '.')
        reachedDot = true;

    integer += (char) nextChar;
    readChar();
} while (Character.isDigit(nextChar) || (!reachedDot && nextChar == '.'));