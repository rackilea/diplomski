char[] chars = phrase.toUpperCase().toCharArray();
for (char letter:chars)
{
    int keyCode = (int)letter;
    r.keyPress(keyCode);
    r.keyRelease(keyCode);
}