try (final BufferedReader reader = new BufferedReader(new InputStreamReader(new CipherInputStream(new FileInputStream(file), dcipher), "UTF-8"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        list.add(line);
    }
}