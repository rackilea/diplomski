try (BufferedReader br = new BufferedReader(
     new InputStreamReader(new File(file), charset))
 ) {
    String line;
    boolean start = false;
    // Read the file line by line
    while ((line = br.readLine()) != null) {
        if (start) {
            // Here the start pattern has been found already
            if (line.equals("{/AAAA}")) {
                // The end pattern has been reached so we stop reading the file
                break;
            }
            // The line is not the end pattern so we treat it
            doSomething(line);
        } else {
            // Here we did not find the start pattern yet
            // so we check if the line is the start pattern
            start = line.equals("{AAAA}");
        }
    }
}