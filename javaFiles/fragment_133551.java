private static int getRow(Scanner c, Board o) {
    int b=-1;
    while(b<0 || b>o.getRow()/2) {
        System.out.println("Please enter correct row");
        b=c.nextInt();
    }
    return b;
}