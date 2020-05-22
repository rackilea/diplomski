static void getAllData(final Integer choice) throws Exception {
    final BufferedReader br = new BufferedReader(new FileReader("Shadow.txt"));
    String data = "";
    final StringBuilder builder = new StringBuilder();
    if(choice.equals(1)) {
        while(data != null) {
            data = br.readLine();
            if(data != null) {
                builder.append(data + "\n");
            }
        }
        writeToFile(builder.toString());
        br.close();
    }
}

static void writeToFile(final String data) throws IOException {
    final File file = new File("Shadow.txt");
    final FileWriter fileWriter = new FileWriter(file, true);
    final BufferedWriter bw = new BufferedWriter(fileWriter);
    bw.write(data);
    bw.flush();
    bw.close();
}