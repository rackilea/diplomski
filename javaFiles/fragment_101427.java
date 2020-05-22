public Reader() {
    initComponents();
    BufferedReader br = new BufferedReader(new FileReader("file1.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        jTextArea1.setText(sb.toString())
    } finally {
        br.close();
    }         
}