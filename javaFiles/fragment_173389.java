do {
    System.out.println("Enter the  password:");
    pw1 = keyboard.nextLine();
    System.out.println("Renter the password:");
    pw2 = keyboard.nextLine();
    count++;
    if (pw1.equals(pw2)) {
        System.out.println("Correct");
    } else if (count >= 3) {
        System.out.println("Account is suspended");
    }
} while (count < 3 && !pw1.equals(pw2));