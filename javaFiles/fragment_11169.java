public static void main(String[] args) {
      Scanner s = null;
      Vector<String> v = new Vector<String>();
      String words;

      System.out.println("Enter a sentence: ");
      try {
          s = new Scanner(System.in);
            while (s.hasNext()) {
                words = s.next();
                v.add(0, words);
            }
        } 
        finally {
               if (s != null) {
                   s.close(); // Close scanner when no more input is available
                }
      }  
      System.out.println(v);
  }