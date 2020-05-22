int countColons() throws IOException {
    try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file.txt), "UTF-8"))) {
        int count = 0;
        int c;
        while ((c = in.read()) >= 0) {
            if (c == ':') {
                count++;
            }
        }
        return count;
    }
}