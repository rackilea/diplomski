while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    fileLines.add(line);
    if (line.trim().toLowerCase().contains(MARKER_LINE1.toLowerCase())) {
        fileLines.add(TEXT_TO_ADD1);
    }
    if (line.trim().toLowerCase().contains(MARKER_LINE2.toLowerCase())) {
        fileLines.add(TEXT_TO_ADD2);
    }
}