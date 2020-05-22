public static Student load(BufferedReader infile) throws IOException {
    String line;
    line = infile.readLine();

    // Check if we reached end of file
    if (line == null) {
        return null;
    }

    // Split the fields by the "|", and check that we have no less than 4
    // fields.
    String[] fields = line.split("\\|");
    if (fields.length < 4) {
        return null;
    }

    // Parse the test scores
    int[] tests = new int[3];
    for (int i = 0; i < 3; i++) {
        try {
            tests[i] = Integer.parseInt(fields[i + 1]);
        } catch (NumberFormatException e) {
            // The field is not a number. Return null as we cannot parse
            // this line.
            return null;
        }
    }

    // All checks done, data ready, create a new student record and return
    // it
    return new Student(fields[0], tests[0], tests[1], tests[2]);
}