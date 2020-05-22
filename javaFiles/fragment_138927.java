public synchronized DominoTiles deal(int a, int b) throws  FileNotFoundException, InterruptedException {
    DominoTiles dealt = new DominoTiles(a, b);
    System.out.println("Dealer is dealing");

    if ((count < 28 && check[a][b] == false)) {
        System.out.println("Checking " + a + " " + b + ": " + check[a][b]);

        System.out.println(a + " " + b + " has been dealt");

        check[a][b] = true;
        check[b][a] = true;
        System.out.println("Checking now : " + check[a][b]);
        count++;
        System.out.println("Count = " + count);


    } else if ((count < 28 && (check[a][b] == true || check[b][a] == true)) || (check[b][a] == true)) {
        System.out.println("I tried to deal the same again!" + a + " " + b + " and it was " + check[a][b] + " " + check[b][a
        ]);
        int c = r.nextInt(7);
        int d = r.nextInt(7);
        dealt = deal(c, d);
    } else {
        System.out.println("All tiles have been dealt");
        System.exit(0);
    }

    return dealt;

}