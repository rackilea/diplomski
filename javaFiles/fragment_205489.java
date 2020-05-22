public static void main(String[] args) {
    String[][] groups = new String[10][10];

    try {
        BufferedReader reader = new BufferedReader(new FileReader("somefile"));

        String line = reader.readLine();
        int row = 0;
        int column = 0;

        while (line != null) {
            String[] groupArray = line.split("\\.");
            for (int i = 0; i < groupArray.length; i++) {
                groups[row][column] = groupArray[i];
                column++;
                if (column > 9) {
                    column = 0;
                    row++;
                }
                if (row > 9) {
                    //throw exception or just ignore further groups
                }
            }
            line = reader.readLine();
        }
    } catch (IOException e) {
        //TODO: handle exception
    } 
}