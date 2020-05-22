for (int row = 0; row < height; ++row) {
    for (int col = 0; col <= row; ++col) {
        if ((col + row) % 2 == 0) {
            System.out.print("XX");
        } else {
            System.out.print("YY");
        }
    }
    System.out.println();
}