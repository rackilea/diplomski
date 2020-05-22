public static void main(String[] args) {
    int testSize = 4;
    Test test = new Test(testSize);

    for (int i = 0; i < testSize; i++) {
        for (int j = 0; j < testSize; j++) {
            int index = test.toIndex(i, j);
            int coordinates[] = test.toCoordinates(index);
            System.out.println(index + " == " + coordinates[0] + "," + coordinates[1]);
        }
    }
}