public static void readMarks() 
  {
      String Assessment1 = null, Assessment2 = null, Assessment3 = null;
      int mark1 = 0,mark2 = 0,mark3 = 0;
       try {
       File doc = new File ("marks.txt");
       if(!doc.exists())
       {
        System.out.println ("Marks.txt Does Not Exist");
       }
       Scanner input = new Scanner(doc);
         while (input.hasNext()){
          Assessment1 = input.next();
          mark1 = input.nextInt();
          Assessment2 = input.next();
          mark2 = input.nextInt();
          Assessment3 = input.next();
          mark3 = input.nextInt();

        }  
      input.close();
      System.out.println(Assessment1 + " "+mark1 + Assessment2 +mark2+ " " + Assessment3 +mark3+ " ");
    }
    catch (FileNotFoundException ex) {
      System.err.println("File has not been found");
    } 

     }