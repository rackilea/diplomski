for (i=0; i < 4; i++) {
    for (j=0; j < 5; j++) {
        if (j > 0) System.out.print(" ");
        System.out.print(String.format("%5s" , String.valueOf(twod[i][j])));
    }
    System.out.println();
}