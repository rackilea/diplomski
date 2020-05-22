public static void main(String[] args) {
    String original = "", reverse = ""; // Create empty variables to hold the input and output
    Scanner in = new Scanner(System.in); // Create an object to read from StdIn

    while(!original.contains("exit"))
    // Read from StdIn as long as user does not input "exit"
    {
        original = "";
        reverse = "";
        System.out.println("Enter a sentence to be reversed: ");
        original = in.nextLine(); // Save the user's input as "original"

        int length = original.length(); // Get the length of the input
        for (int i = length - 1; i >= 0; i--) // Iterate over each character of the input, starting from the end until you reach the beginning and add the character to the "reverse" string
        reverse = reverse + original.charAt(i); 

        System.out.println(reverse); // Output the result
    }
}