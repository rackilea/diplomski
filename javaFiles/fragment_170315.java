List<String> lines = new LinkedList<>();

try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    while ((line = br.readLine()) != null)
        lines.add(line);
} catch (IOException e) {
    e.printStackTrace();
}