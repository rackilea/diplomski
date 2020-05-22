public String toString() {
    String str = "";
    NumberFormat df = new DecimalFormat("0.0000");

        for (int j = 0; j < numOfCoord; j++) {
            str += df.format(coordinates[0][j]) + "\t" + 
                   df.format(coordinates[1][j]) + "\t" +
                   df.format(coordinates[2][j]) + "\t" + 
                   df.format(coordinates[3][j]) + "\n";
        }

    System.out.println(str);
    return str;
}