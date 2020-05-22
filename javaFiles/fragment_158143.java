public static boolean isEnglishWord(String[] arrayOfWords) throws IOException {
     for (String line : Files.readAllLines(Paths.get("words.txt"), StandardCharsets.UTF_8)) {
         if(arrayOfWords[0].equals(line)) // use `equals()` instead of `==`
         {
             return true;
         }
      //   else    --> If word is not found, you will eventually return false
       //  {
       //      return false;
       //  }
     }
     return false;
    }