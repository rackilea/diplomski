// Iterate as long as you have remaining lines
while (inputReader.hasNextLine()) {
    String line = inputReader.nextLine();
    // For each line, slip the tokens using space as separator
    for (String token : line.split(" ")) {
        System.out.println(token);
    }
}