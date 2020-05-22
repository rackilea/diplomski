public static void main(String[] args) throws Exception {

    Pattern pattern = Pattern.compile("[A-G]+");
    Pattern pattern2 = Pattern.compile("[V]+");

    List<String[]> mat = new ArrayList<String[]>();
    String[] row1 = { "A", "V", "V", "V", "VV", "V", "V", "V" };
    String[] row2 = { "E", "F", "V", "E", "VF", "E", "V", "E", };
    String[] row3 = { "C", "D", "V", "C", "VD", "B", "V", "C" };
    String[] row4 = { "A", "A", "V", "A", "VA", "G", "V", "A" };
    String[] row5 = { "V", "D", "V", "V", "VD", "E", "V", "V" };
    String[] row6 = { "A", "V", "V", "A", "VV", "V", "V", "A" };

    mat.add(row1);
    mat.add(row2);
    mat.add(row3);
    mat.add(row4);
    mat.add(row5);
    mat.add(row6);

    int rowSize = 6;
    int colSize = 8;

    String[][] matrix = mat.toArray(new String[rowSize][colSize]);

    for (int i = 0; i < colSize; i++) {

        StringBuffer sf = new StringBuffer();
        for (int j = 0; j < rowSize; j++) {
            sf.append(matrix[j][i]);

        }

        Matcher matcher = pattern.matcher(sf.toString());
        Matcher matcher2 = pattern2.matcher(sf.toString());

        if (matcher.find()) {
            System.out.println("R");
        } else if (matcher2.matches()) {
            System.out.println(" ");
        }

    }

}