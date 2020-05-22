void mergeSplittedPatterns(XWPFDocument document)
{
    List<XWPFParagraph> paragraphs = document.paragraphs

    for(XWPFParagraph paragraph : paragraphs)
    {
        List<XWPFRun> runs = paragraph.getRuns()

        int firstCharRun,closingCharRun
        boolean firstCharFound = false;
        boolean secondCharFoundImmediately = false;
        boolean closingCharFound = false;
        boolean gotoNextRun = true

        boolean scan = (runs!=null && runs.size()>0)
        int index = 0

        while(scan)
        {
            gotoNextRun = true;
            XWPFRun run = runs.get(index)
            String runText = run.getText(0)
            if(runText!=null)
                for (int i = 0; i < runText.length(); i++)
            {
                char character = runText.charAt(i);

                if(secondCharFoundImmediately)
                {
                    closingCharFound = (character=="}")
                    if(closingCharFound)
                    {
                        closingCharRun = index

                        if(firstCharRun==closingCharRun)
                        {
                            firstCharFound = secondCharFoundImmediately = closingCharFound = false
                            continue;
                        }
                        else
                        {
                            String mergedText= ""
                            for(int j=firstCharRun;j<=closingCharRun;j++)
                            {
                                mergedText += runs.get(j).getText(0)
                            }
                            runs.get(firstCharRun).setText(mergedText,0)

                            for(int j=closingCharRun;j>firstCharRun;j--)
                            {
                                paragraph.removeRun(j)
                            }
                            firstCharFound = secondCharFoundImmediately = closingCharFound = gotoNextRun = false
                            index = firstCharRun
                            break;
                        }
                    }
                }
                else if(firstCharFound)
                {
                    secondCharFoundImmediately = (character=="{")
                    if(!secondCharFoundImmediately)
                    {
                        firstCharFound = secondCharFoundImmediately = closingCharFound = false
                    }
                }
                else if(character=="\$")
                {
                    firstCharFound = true;
                    firstCharRun = index
                }
            }

            if(gotoNextRun)
            {
                index++;
            }

            if(index>=runs.size())
            {
                scan = false;
            }
        }
    }
}