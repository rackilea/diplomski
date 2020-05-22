final URL url = new URL("https://www.facebook.com");
try (final BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
    // Read the whole page
    while (true) {
        final String line = br.readLine();
        if (line == null) {
            break;
        }

        System.out.println(line);
    }
}