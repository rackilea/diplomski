public static void digital(String [][] first, String[][] second, String[][] colon, String[][] third, String[][] fourth) {

    for(int j = 0; j < 6; j++) {

        for(in i = 0; i < 3; i++) {
            System.out.print(first[j][i]);
        }
        System.out.print(" ");

        for(in i = 0; i < 3; i++) {
            System.out.print(second[j][i]);
        }
        System.out.print(" ");

        for(in i = 0; i < 3; i++) {
            System.out.print(colon[j][i]);
        }
        System.out.print(" ");

        for(in i = 0; i < 3; i++) {
            System.out.print(third[j][i]);
        }
        System.out.print(" ");

        for(in i = 0; i < 3; i++) {
            System.out.print(fourth[j][i]);
        }
        System.out.println();
    }

} //method to print the clock out