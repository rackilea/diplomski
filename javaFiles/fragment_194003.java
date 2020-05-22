while (scanner.hasNextLine()) {
    if (scanner.findInLine(...)) {
        ...
    }
    // Read to the end of the line whether we found something or not
    scanner.nextLine();
}