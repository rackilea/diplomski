List<List<Integer>> rows = new ArrayList<>(5);
try (BufferedReader br = new BufferedReader(new FileReader(new File("Test.txt")))) {
    String text = null;
    while ((text = br.readLine()) != null) {
        System.out.println(text);
        String[] parts = text.split(",");
        List<Integer> row = new ArrayList<>(parts.length);
        for (String value : parts) {
            row.add(Integer.parseInt(value.trim()));
        }
        rows.add(row);
    }
} catch (IOException ex) {
    ex.printStackTrace();
}