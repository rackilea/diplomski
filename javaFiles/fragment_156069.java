while (fileScanner.hasNextLine()) {
    String line = fileScanner.nextLine();
    if (line.startsWith("#")) {
        continue;
    }
    // Go to next line
}