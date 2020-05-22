if (tableLineScanner.hasNextLine()) {
    String firstLine = tableLineScanner.nextLine();

    if (tableLineScanner.hasNextLine()) {
        String secondLine = tableLineScanner.nextLine().replaceAll(...);

        tableFields.add(firstLine + secondLine);
    } else {
        // No-second-line error handling goes here
    }
} else {
    // No-first-line error handling goes here (if any)
}