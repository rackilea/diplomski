if (i != numberOfGuesses) {
      System.out.println("You did not use these guesses: ");
      for (int j = i + 1; j <= numberOfGuesses; j++) {
        System.out.println(j);
      }
    }