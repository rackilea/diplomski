//no changes before
} else if (hierarchy.equals("user")) {
    for (int i = 0; i < users.length; i++) {
        if (username.equals(users[i])) {
            for (int a = 0; a < usersPassword.length; a++) {
                if (password.equals(usersPassword[i])) {
                    System.out.println("You have successfully logged in!");
                    status = "user";
                    currentUserIndex = i;
                    return;
                } else {
                    System.out.println("Wrong password");
                    return;
                }
            }
        }
    }
    if (!status.equals("user")) {
        System.out.println("User not recognized");
        return;
    }
}
//no changes after