try (BufferedReader br = new BufferedReader(new FileReader("text.txt"));
     BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        String[] values = line.split(" ");
        if (values.length >= 3)
            bw.write(values[0] + ' ' + values[1] + ' ' + values[2] + '\n');
    }
}