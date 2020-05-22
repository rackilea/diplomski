List<FormattingRun> formattingRuns = new ArrayList<FormattingRun>();
int numFormattingRuns = richTextString.numFormattingRuns();
for (int fmtIdx = 0; fmtIdx < numFormattingRuns; fmtIdx)
{
    int begin = richTextString.getIndexOfFormattingRun(fmtIdx);
    short fontIndex = richTextString.getFontOfFormattingRun(fmtIdx);

    // Walk the string to determine the length of the formatting run.
    int length = 0;
    for (int j = begin; j < richTextString.length(); j++)
    {
        short currFontIndex = richTextString.getFontAtIndex(j);
        if (currFontIndex == fontIndex)
            length++;
        else
            break;
    }
    formattingRuns.add(new FormattingRun(begin, length, fontIndex));
}