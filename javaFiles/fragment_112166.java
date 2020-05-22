boolean currentLineSet = false;
while ((line = br.readLine()) != null)
{                       
    if (line.contains("ua, "))
    {
       if (!currentLineSet) {
           sCurrentLine = line;
           currentLineSet = true;
       } else {
           sNextLine=line;
       //processing
       sCurrentLine = sNextLine;
       }
    }