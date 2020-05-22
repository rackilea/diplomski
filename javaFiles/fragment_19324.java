String fileName = args[0]; // assuming the user has provided arguments

try (InputStream in = Files.newInputStream(Paths.get(fileName));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
        String line;
        while ((line = reader.readLine()) != null) {
            string1 = string1 + " " + line;
        }
}