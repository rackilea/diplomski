Pattern p = Pattern.compile("^(\\d+ \\w+ \\w+)");
try (BufferedReader br = new BufferedReader(new FileReader("text.txt"));
     BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"))) {
    String line;
    while ((line = br.readLine()) != null) {
        Matcher m = p.matcher(line);
        if (m.find())
            bw.write(m.group(1) + '\n');
    }
}