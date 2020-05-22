for(String sLine : words) 
{
    for(String searchWord: searchWords)
    {
        if (sLine.contains(searchWord)) 
        {
            int index = words.indexOf(sLine);
            System.out.println("");
            System.out.println("Got a match of "+searchWord+" at line " + index);
        }
    }
 }