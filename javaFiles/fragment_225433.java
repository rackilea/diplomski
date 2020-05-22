int linesToSkip = 28;

try (BufferedReader br = new BufferedReader(new FileReader(file))) {

    String line;
    while ( (line = br.readLine()) != null) {
        if (linesToSkip-- > 0) {
            continue;
        }

        String[] values = line.split(" +");

        int index = 0;
        for (String value : values) {
            System.out.println("values[" + index + "] = " + value);
            index++;
        }
    }
}