public static void main(String[] args) throws IOException, FileNotFoundException {
    // change this value to whatever row count you actually have
    int NUM_ROWS = 100;
    double[][] array = new double[NUM_ROWS][3];
    BufferedReader reader = new BufferedReader(new FileReader("Dimensions.txt"));

    int counter = 0;
    while (true) {
        String line = reader.readLine();
        if (line == null) break;
        String[] parts = line.trim().split("\\s+");
        for (int i=0; i < 3; ++i) {
            array[counter][i] = Double.parseDouble(parts[i]);
        }

        System.out.println(line);
        ++counter;
    }
    reader.close();  
}