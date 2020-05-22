do {
    System.out.println("3 letters please:");
    letter[i] = scr.nextLine();
    if (Pattern.matches("[a-zA-Z]+", letter[i]) == false || letter[i].length() != 3) {
        System.out.println("not letters or too short/long");
    } 
} while (letter[i].length() != 3 && Pattern.matches("[a-zA-Z]+", letter[i]) != true);