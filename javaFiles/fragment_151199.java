public static void parseImportLine(String line)
{
    String[] word = line.split("\\s+");

    for(int i=0;i<= word.length-1;i++)
      {
        if (!(word[i].equals("IMPORT")))
        {
          System.out.println(word[i]);
        }
       }
}