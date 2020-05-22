boolean userExists = false; // flag

for (Users u: userDetails) {
    if (u.getUser().toLowerCase().contains(userName.toLowerCase())) {
        System.out.println("Exist");
        userExists = true; // update flag
    }
}

// check if user doesn't exist
if (!userExists)
    System.out.println("Does not exist");