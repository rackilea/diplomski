public static void main(String[] args) throws IOException {
    double[][] result = readFile("array.txt");

    for (int i = 0; i < result.length; i++) {
        boolean isFirst = true;
        for (int k = 0; k < result[i].length; k++) {
            if (isFirst)
                isFirst = false;
            else
                System.out.print(", ");
            System.out.printf("%5s", result[i][k]);
        }
        System.out.println();
    }
}