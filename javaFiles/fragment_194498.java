char[][] board = new Char[20][20];
 //Place As
 for (int i = 1; i <= 20; i++) { //20 As
     int randX = (int) (Math.random() * 20); //random number between 0-19
     int randY = (int) (Math.random() * 20);
     while (board[randX][randY] != null) { //find a free cell
         randX = (int) (Math.random() * 20);
         randY = (int) (Math.random() * 20);
      }
      board[randX][randY] = 'A'; //insert A
  }