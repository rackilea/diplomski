String getBracketContent(String str)
{
    int startIdx = str.indexOf('(')
    int endIdx = str.indexOf(')')

    String content = str.subString(startIdx + 1, endIdx);
}