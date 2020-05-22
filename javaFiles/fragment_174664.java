public static void main(String[] args) throws IOException {
    ArrayStructure s = new ArrayStructure();
    s.add(0, 0, "1");
    s.add(1, 1, "4");

    String[][] data = s.toArray();
    for (int i = 0; i < data.length; ++i) {
        for (int j = 0; j < data[i].length; ++j)
            System.out.print(data[i][j] + " ");
        System.out.println();
    }
}