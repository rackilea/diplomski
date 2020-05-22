/**
 * Prompts the user for input and reads from standard input (stdin).
 * Note: Always check if the return is null!
 * 
 * @param description Describes the user input.
 * @return A String of the input, or null when failed.
 */
private String getInput(String description) {
    System.out.print(description + ": ");
    String input = null;

    InputStreamReader stream = null;
    BufferedReader reader = null;
    try {
        // Open a stream to stdin
        stream = new InputStreamReader(System.in);

        // Create a buffered reader to stdin
        reader = new BufferedReader(stream);

        // Try to read the string
        input = reader.readLine();           
    } catch (IOException e) {
        e.printStackTrace();
    } 

    return input;
}

/**
 * Display the login prompt.
 */
private boolean promptLogin() {
    // prompt for user name and password
    String user = getInput("Enter username");
    String pass = getInput("Enter password");

    if (user == null || pass == null) {
        System.out.println("Invalid login information.");
        return false;
    }

    return true;
}