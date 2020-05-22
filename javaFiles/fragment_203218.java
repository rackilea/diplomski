private static int[] getCounts(Scanner input) {

   int[] counts = new int[3];

   while(input.hasNextLine()){
      String line = input.nextLine();
      counts[0]++; // lines

      counts[2]+=line.length(); //chars

      //count words
      //for simplicity make a new scanner could probably be better
      //using regex or StringTokenizer
      try(Scanner wordScanner = new Scanner(line)){
           while (wordScanner.hasNext()) {
               wordScanner.next();
               count[1] ++;  //words
           }
      }
   }

   return counts;