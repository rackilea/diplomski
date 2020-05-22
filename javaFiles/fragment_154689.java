// read terminating newline that remained after last int input
sc.nextLine();

while (selection == 1) {
    System.out.println("Please enter a sentence");
    sentence = sc.nextLine();

    if (sentence.equals("")) {
        selection = 1;
    } else {
        selection = -1;
    }
}