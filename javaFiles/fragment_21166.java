public static void countspecial(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
          return ;
        }
        int countSpecial = 0;

        for (int i = 0; i < userInput.length(); i++) {
           if (userInput.substring(i, i+1).matches("[^A-Za-z0-9]")) {
              countSpecial++;
           }

        }
        System.out.println("The number of special chars is: " + countSpecial);
        }