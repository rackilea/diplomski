// Assuming the time value is not valid.
boolean isValidTime = false;

// While the time value is not valid…
while (!isValidTime) {
    System.out.println("Enter the time: ");
    time = sn.nextInt();

    if (time < 0 || time > 10) {
        System.out.println("You have entered invalid time value!");
    } else {
        // The time value is valid now!
        isValidTime = true;
    }
}