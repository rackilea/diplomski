char [] oldChars = new char[5];

String stripControlChars(String s)
{
    final int inputLen = s.length();
    if ( oldChars.length < inputLen )
    {
        oldChars = new char[inputLen];
    }
    s.getChars(0, inputLen, oldChars, 0);