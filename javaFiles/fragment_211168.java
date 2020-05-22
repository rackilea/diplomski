for(int i=0;i<rows;i++){
    System.out.println("Row " + (i + 1));
    for(int j=0;j<3;j++){
        System.out.print(" "+seatsLeft[i][j]);
    }
    System.out.print(" ");
    for(int j=0;j<3;j++){
        System.out.print(" "+seatsRight[i][j]);
    }
    System.out.println("");
}