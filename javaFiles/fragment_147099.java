String cc = "(1,167,2,'LT2A',45,'Weekly','1,2,3,4,5,6,7,8,9,10,11,12,13'),";

Scanner s = new Scanner(cc);
  try
  {
     while (s.hasNextLine())
     {
        String[] tokens = s.nextLine().split("'"); //split it using ' delimiter 
        for (int i = 0; i < tokens.length; i++)
        {
           String[] ss = tokens[i].split(","); // split it using " delimiter 
           // do the processing for tokens here
        }
     }
  }
  finally
  {
     s.close();
  }