for (int i = 0; i < 10; i++) {
    for (int c = 0; c < 10; c++) {
        if (i == c) {
            System.out.print("*");
        } else {
            System.out.print("-");
        }
        System.out.println(".");
    }
}