private static String allLetters(String charsetName)
{
    CharsetEncoder ce = Charset.forName(charsetName).newEncoder();
    StringBuilder result = new StringBuilder();
    for(char c=0; c<Character.MAX_VALUE; c++)
    {
        if(ce.canEncode(c) && Character.isLetter(c))
        {
            result.append(c);
        }
    }
    return result.toString();
}