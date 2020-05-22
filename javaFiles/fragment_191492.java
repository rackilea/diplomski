while (true) {
    screen.displayString("Enter the username:  ");
    String usernameLogin = keypad.getString();
    screen.displayString("Enter the password:  ");
    String passwordLogin = keypad.getString();

    if (manager.getUsername().equals(usernameLogin) && manager.getPassword().equals(passwordLogin)) {
        no = manager.getId();
        break;
    }

    for (User user : users) {
        if (user.getUsername().equals(usernameLogin) && user.getPassword().equals(passwordLogin)) {
            no = users.get(i).getId();
            break;
        }
    }

    screen.displayStringLine("Incorrect username or password. Try Again!");
}