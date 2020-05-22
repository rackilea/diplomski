final static String filename = "FILENAME.txt";

   public static void main(String[] args) {

      Scanner scan = null;
      File f = new File(filename);
      try {
         scan = new Scanner(f);
      } catch (FileNotFoundException e) {
         System.out.println("File not found.");
         System.exit(0);
      }

      int total = 0;
      boolean foundInts = false; //flag to see if there are any integers

      while (scan.hasNextLine()) { //Note change
         String currentLine = scan.nextLine();
         //split into words
         String words[] = currentLine.split(" ");

         //For each word in the line
         for(String str : words) {
            try {
               int num = Integer.parseInt(str);
               total += num;
               foundInts = true;
               System.out.println("Found: " + num);
            }catch(NumberFormatException nfe) { }; //word is not an integer, do nothing
         }
      } //end while 

      if(!foundInts)
         System.out.println("No numbers found.");
      else
         System.out.println("Total: " + total);

      // close the scanner
      scan.close();
   }