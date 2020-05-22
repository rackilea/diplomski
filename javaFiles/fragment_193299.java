private void loadFile(File fileC) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
        while (true) {
            String s = reader.readLine();
            if (s == null) {
                break;
            }
            so += " "+s;  // here
        }
    }
    parseMethod();
}