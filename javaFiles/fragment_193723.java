while(playCount < 3) {
    System.out.print("Please enter either (R)ock, (P)aper, or (S)iccors: ");
    player1 = scan.nextLine().toUpperCase().charAt(0);
    System.out.print("Please enter either (R)ock, (P)aper, or (S)iccors: ");
    player2 = scan.nextLine().toUpperCase().charAt(0);

    // recompute the winner each time
    int winner = winningPlayer(player1, player2);
    ...
}