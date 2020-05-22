public static double[][] readFile(String fileName) throws IOException {
    double data[][] = new double[30][6];
    int indexRow = 0, indexCol = 0;

    File file = new File(fileName);
    try (BufferedReader input = new BufferedReader(new FileReader(file))) {
        String temp = input.readLine();
        while (temp != null) {
            if (temp.trim().length() > 0) {
                if (Character.isDigit(temp.charAt(0))) {
                    data[indexRow][indexCol] = Double.parseDouble(temp);

                    if (indexCol < 6)
                        indexCol++;
                    if (indexRow < 30 && indexCol % 6 == 0) {
                        indexRow++;
                        indexCol = 0;
                    }
                } else {
                    //do something
                }
            }

            temp = input.readLine();
        }
    }
    System.out.println(Arrays.deepToString(data));

    return data;
}