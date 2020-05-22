do {
    write = tast.next();
    int i = 7;

    if (write.length() > i) {
        System.out.println("\nYour new password is: " + write);
    } else {
        System.out.println("Wrong! password have to contain 8 or more characters! Try again!");
    }
} while(write.length()<=i)