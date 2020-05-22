final List<String> list = new LinkedList<String>();
try {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(new CipherInputStream(new FileInputStream(file), dcipher)));
    String line;
    while ((line = reader.readLine()) != null) {
        list.add(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}