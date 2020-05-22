for (int l = 0; l < 4; l ++) {
    for (int i = 0; i < 5 - 2l; i++) 
        System.out.print(" ");
    for (int i = 0; i < 2 + 2l; i++)
        System.out.print("*");
    System.out.println();
}