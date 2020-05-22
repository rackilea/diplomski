if (passwordInput.hasNextInt()) {
    if (passwordInput.nextInt() != builtInPassword) {
        System.out.println("You entered the right format \nbut the password is WRONG!");
    } else {
        System.out.println("Thanks,your password is correct");
    }
} else {
    System.out.println("WRONG format!");
}