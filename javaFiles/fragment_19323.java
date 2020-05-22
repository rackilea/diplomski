try (InputStream in = getClass().getResourceAsStream("/res/com/example/text.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
        String line;
        while ((line = reader.readLine()) != null) {
            string1 = string1 + " " + line;
        }
}