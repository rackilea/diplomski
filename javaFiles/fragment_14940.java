public String replace (CharSequence target, CharSequence replacement)
{
    String targetString = target.toString();
    String replaceString = replacement.toString();
    int targetLength = target.length();
    int replaceLength = replacement.length();

    int startPos = this.indexOf(targetString);
    StringBuilder result = new StringBuilder(this);    
    while (startPos != -1)
    {
        // Replace the target with the replacement
        result.replace(startPos, startPos + targetLength, replaceString);

        // Search for a new occurrence of the target
        startPos = result.indexOf(targetString, startPos + replaceLength);
    }
    return result.toString();
}