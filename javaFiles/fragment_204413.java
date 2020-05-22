String[][] rows = new String[15][8];
for (int i = 0; i < rows.length; i++) {
    System.out.println();
    for (int j = 0; j < 8; j++) {
        if (false) {
            rows[i][j] = "Hi";
        } else {
            double foo = (Math.random() * 2) + 8;

            rows[i][j] = String.format("%.2f", foo);

            System.out.print(rows[i][j] + " ");
        }
    }
}