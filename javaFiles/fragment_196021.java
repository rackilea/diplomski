while (!repeat) {
    //...
    for (int i = 0; i < (Board.length); i++) {
        {
            Board[i] = A; //Makes each element "O"
            //...
            if (i == C) { //Makes only the current cooridinate "X"
                Board[i] = Board[i].replace(A, B);
            }
            //...
        }
        System.out.print(Board[i]);
    }
}