File file = new File("test.txt");
try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    while ((line = br.readLine()) != null) {
        // ...
    }
} catch (IOException e) {
    e.printStackTrace();
}