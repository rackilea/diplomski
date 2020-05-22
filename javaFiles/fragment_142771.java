public static void display2DArray(String[][] array){
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++) {
            System.out.println("Document "+i+ "  Section "+j);
            System.out.println(" "+array[i][j]);
        }
        System.out.println(" ");
    }
}