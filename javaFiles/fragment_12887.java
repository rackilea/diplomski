String user="";
String pass="";

boolean foundUser = false; // Keeps track of if we found the user's credentials

while(scan.hasNextLine()) {
    // get username (we know it is there)
    user = scan.nextLine();

    // Get password, making sure to check it exists!
    if(scan.hasNextLine())
        pass = scan.nextLine();

    // If we have found the user's credentials, log in
    if (inpUser.equals(user) && inpPass.equals(pass)) {
        accountGUI s = new accountGUI();
        s.setVisible(true);
        foundUser = true;
        break; // We found the user, stop looping (stop looking)
    }
}

// If we've reached the end of the file, and not found the user
if(!foundUser)
    JOptionPane.showMessageDialog(null,"Wrong Password / Username");