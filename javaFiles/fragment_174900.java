public static void main(String[] args) {

    final String pass = "cherry"; // Defining the pass variable
    String word; // Defining the word variable
    boolean running = true; // Defining the running variable

    Scanner scanner = new Scanner(System.in); // Making new Scanner Instance

    do {
        System.out.print("Enter a word: "); // Informing the User to enter a word
        word = scanner.nextLine(); // Retrieving the Word from Input

        char first = word.charAt(0); // Get the first character of the word by using the #charAt(int) method
        char last = word.charAt(word.length() - 1); // Get the second character by looking at the total length of the word and subtracting 1

        // Make the word lowercase and see if it matches the "pass" variable we defined
        if (word.toLowerCase().equals(pass)) {
            running = false; // Stop the loop
            System.out.println("The program is now terminating..."); // Informing the user that the program stops

            // Checking if the first character equals the last
        } else if (first == last) {
            // Informing the user that the first character is equal to the last last character
            System.out.println("The first character is equal to it's last character:" + word);
        } else {
            // Informing the user that the first character is not equal to the last last character
            System.out.println("The first character is not equal to it's last character:" + word);
        }
    } while (running);
}