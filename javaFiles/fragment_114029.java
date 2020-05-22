public boolean checkCredentials(String username, String password) throws IOException {
    // these two are begging to be constants or inlined. 
    final String usernametxt = "users.txt";
    final String passwordtxt = "passwords.txt";

    if (username == null || password == null) {
        // You probably don't want this in production code.
        // Exceptions are your best friends when something unexpected occurs.
        return false;
    }

    try (final Reader fileReader = new FileReader(usernametxt);
         final Reader passwordReader = new FileReader(passwordtxt)) {

        Scanner userScanner = new Scanner(fileReader);
        Scanner passwordScanner = new Scanner(passwordReader);

        while(userScanner.hasNext()) {
            final String user = userScanner.next();
            if (!passwordScanner.hasNext()) {
                // So the password file is shorter than the userfile?
                // We probably want to log or alert the poor DevOp guys.
                // throwing an exception seems like the right thing to do here!
                return false;
            }
            final String candidatePassword = passwordScanner.next();
            if (!user.equalsIgnoreCase(username)) {
                // This is not the droid we're looking for
                // Also notice that, since we KNOW that user can't be null,
                // we're using the force to save ourselves
                // from dreaded NullPointerExceptions!
                continue;
            }

            if (!candidatePassword.equals(password)) {
                // Hmmm, wrong password, I guess?
                // Not sure what do do next, but we DO NOT need to keep looping
                // So let's return early and save some EC2 Cycles.
                return false;
            }

            // If we ever reach here, we got ourselves a winner!
            return true;
        }
    } // yay for autocloseable
    return false;
}