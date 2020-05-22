boolean winAtLife = false;
while((user = bufferedReader.readLine()) != null){
    String candidatePassword = br.readLine();
    if (candidatePassword == null) {
        // So the password file is shorter than the userfile? 
        // We probably want to log or alert the poor DevOp guys. 
        // throwing an exception seems like the right thing to do here!
        break;
    }

    if (!user.equalsIgnoreCase(username.getText())) {
        // These are not the droid we're looking for, Better luck next line!
        continue;

        // Also notice that, since we KNOW that user can't be null,
        // we're using the force to save ourselves from dreaded NullPointerExceptions!
    }

    if (!candidatePassword.equals(password.getPassword())) {
        // Hmmm, wrong password, I guess?
        // Not sure what do do next, but we DO NOT need to keep looping
        // since we've found our droid/user/whatever.
        // So let's break and save some EC2 Cycles.
        break; 
    }

    // If we ever reach here, we got ourselves a winner!
    pass = candidatePassword
    winAtLife = true;
}