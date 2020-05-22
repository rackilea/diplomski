public static boolean compareInFile(String inputWord) {     

         String word = "";     

        File file = new File("Deepak.txt");     
        try {     
            Scanner input = new Scanner(file);     
            while (input.hasNext()) {     
                word = input.next();     
                if (inputWord.equals(word)) {     
                    return true;     
                }     
            }     

        } catch (Exception error) {     
       }     
        return false;     
   }