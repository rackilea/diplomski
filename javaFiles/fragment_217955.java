public static void readFile() throws IOException
{
    String line;
    ArrayList<String> words = new ArrayList<String>();    
    try
    {
        BufferedReader inFile = new BufferedReader(new FileReader("weather.txt"));

        while ((line = inFile.readLine()) != null)
        {
            String[] temp = line.split("\\t");
            for (String s : temp)
            {
                if(!s.isEmpty())
                {
                    words.add(s);
                }
                else //another \t
                {
                    words.clear();
                    break;
                }   
            }

            /*
             * function to print the values
             */
            getMetadataTriple(words);
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

}