List<int[]> rows = new ArrayList<>(5);
int maxCols = 0;
try (BufferedReader br = new BufferedReader(new FileReader(new File("Test.txt")))) {
    String text = null;
    while ((text = br.readLine()) != null) {
        System.out.println(text);
        String[] parts = text.split(",");
        int[] row = new int[parts.length];
        maxCols = Math.max(maxCols, row.length);
        for (int col = 0; col < parts.length; col++) {
            row[col] = Integer.parseInt(parts[col].trim());
        }
        rows.add(row);
    }
} catch (IOException ex) {
    ex.printStackTrace();
}

int[][] map = new int[rows.size()][maxCols];
for (int row = 0; row < rows.size(); row++) {
    map[row] = rows.get(row);
}