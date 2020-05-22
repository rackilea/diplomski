private static boolean isValidAmount(String input) {

      if (input.isEmpty() || input.equals(" ")) {
        System.out.println("INVALID input:" + input);
        return false;
      }

    if (input.chars().allMatch(Character::isAlphabetic)) {
      System.out.println("INVALID input: " + input );
      return false;
    } else {
      return true;
    }
  }