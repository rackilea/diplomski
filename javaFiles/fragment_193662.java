for (i=0; i < 4; i++) {
    for (j=0; j < 5; j++) {
        if (j > 0) System.out.print(" ");
        System.out.print(twod[i][j]);
    }
    // now that a complete row has been printed, go to the next line
    System.out.println();
}