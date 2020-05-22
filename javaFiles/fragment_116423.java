BufferedReader in = null;
try {
    in = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/Rod/Desktop/123.txt")));
    int column = 0;
    int row = 0;
    int pom;
    while ((pom = in.read()) != -1) {
        pom -= 48;
        if (pom > -1 && pom < 10) {
            System.out.print("" + pom + ", ");
            // board.setDigit(row, column, pom);
            column++;
            if (column > 8) {
                column = 0;
                System.out.println("");
                row++;
                if (row > 8)
                    break;
            }
        }
    }

} catch (Exception e) {
    System.out.print("ERROR");
    // e.printStackTrace();
} finally {
    if (in != null)
        in.close();
}