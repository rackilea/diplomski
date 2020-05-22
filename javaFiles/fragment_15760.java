public static double[][] readFile(String fileName) throws IOException {
    double data[][] = new double[30][6];
    int indexRow = 0, indexCol = 0;

    File file = new File(fileName);
    try (Scanner input = new Scanner(file)) {
        while (input.hasNext()) {
            String temp = input.nextLine();

            if (temp.trim().length() == 0) {
                continue;
            } else {
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
        }
    }
    System.out.println(Arrays.deepToString(data));

    return data;
}