Scanner scan = new Scanner(System.in);
if (scan.hasNextInt()) {
    // Consume int1 or the following if will always be true!
    if (scan.hasNextInt()) {
        // Inside case 1
    } else {
        // Inside case 2
    }
} else {
    // Inside case 3
}