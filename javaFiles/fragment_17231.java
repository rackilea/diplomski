public static String hiddenWord() {
        String password = "abcde";
        String letters = "ab";
        StringBuilder empty = new StringBuilder();

        for (int i = 0; i <= password.length() - 1; i++) {
           //check character is found and replace with X
           if(i<letters.length() && letters.charAt(i) == password.charAt(i)) {
                empty.append("X");
           } 
           //otherwise keep the same character
           else if(i<letters.length() && letters.charAt(i)!= password.charAt(i)){
                empty.append(password.charAt(i));
          }
        }
        return empty.toString();
    }