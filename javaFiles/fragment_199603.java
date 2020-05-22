for (int i = 0; i < str.length(); i++)
{
    char currentChar = str.charAt(i);
    int previousCharCount = count[currentChar];
    int currentCharCount = previousCharCount + 1;
    count[currentChar] = currentCharCount;
}