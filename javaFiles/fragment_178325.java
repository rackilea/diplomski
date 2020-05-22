public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    System.out.println("The words cat, dog, and llama are considered"
            + " profane and will not be allowed.");

    System.out.println("Please enter a sentence:");
    String sentence = keyboard.nextLine();
    sentence = sentence.toLowerCase();

    boolean foundProfane = false;
    if (sentence.matches(".*\\bcat\\b.*")
            || sentence.matches(".*\\bdog\\b.*")
            || sentence.matches(".*\\bllama\\b.*")) {
        foundProfane = true;
    }

    if (foundProfane) {
        System.out.println("Profanity Detected!");
    } else {
        System.out.println("No profanity detected!");
    }

}