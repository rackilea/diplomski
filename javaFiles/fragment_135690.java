FieldOfHonor fieldOfHonor = new FieldOfHonor(player1, opponents);
    String input = "no";
    do {
        fieldOfHonor.battle();
        System.out.println("Would you like to play another game?");
        input = reader.readInput();
    } while("yes".equals(input));