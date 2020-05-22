public void setUpGame(String [] p) {
    System.out.println("This is how we stand.......");
    //Initialize the `players` array.
    players = new Player[p.length];
    for (int i = 0; i < p.length; i++){
        System.out.println(p[i]+" is "+ Player.Status.IN);
        //For each argument, you must create a `Player` object and store it in the array.
        players[i] = new Player(p[i]);
        players[i].setStatus(Status.IN);
    }
    //Once your array is filled, use the data in your program.
    //...
}