boolean invalid;
do {
    System.out.println("3 letters please:");
    letter[i] = scr.nextLine();
    invalid = (Pattern.matches("[a-zA-Z]+", letter[i]) == false || letter[i].length() != 3);
    if (invalid) {
        System.out.println("not letters or too short/long");
    } 
} while (invalid);