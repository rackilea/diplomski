for (FormattingRun run1 : formattingRuns1)
{
    int begin = run1.getBegin();
    int end = begin + run1.getLength();
    short fontIdx = run1.getFontIndex();
    result.applyFont(begin, end, fontIdx);
}
for (FormattingRun run2 : formattingRuns2)
{
    // offset by string length 1
    int begin = run2.getBegin() + richTextString1.length();
    int end = begin + run2.getLength();
    short fontIdx = run2.getFontIndex();
    result.applyFont(begin, end, fontIdx);
}