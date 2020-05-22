String[][] rows = new String[8][15];
for (int i = 0; i < rows.length; i++) {
    System.out.println();
    for (int j = 0; j < 15; j++) {
        if (false) {
            rows[i][j] = "Hi";
        } else {
            double foo = (Math.random() * 2) + 8;

            rows[i][j] = String.format("%.2f", foo);

            System.out.print(rows[i][j] + " ");
        }
    }
}