public static void main(String[] args){

    fillArrays();
    boolean outOfBoundsV;
    boolean outOfBoundsH;
    boolean positionAvailability = false;
    int VerticalMove,HorizontalMove;
    fillBoard();
    board[3][4] = "H";
    boardPositions[3][4] = true;
    // add the two integers that keep track of you previous position:
    int previousRow = 3;
    int previousColumn = 4;
    displayBoard();
    int pickMove;
    for(int i=1;i<=64;i++){
      displayBoardPositions();
      displayPossibleMoves();
      do {
        System.out.println("\nPick one of the displayed moves to do (0-7): ");
        pickMove = scanner.nextInt();
        VerticalMove = moveHorse_Vertical(pickMove);
        HorizontalMove = moveHorse_Horizontal(pickMove);
        outOfBoundsV = checkForOutOfBounds(VerticalMove);
        outOfBoundsH = checkForOutOfBounds(HorizontalMove);
        if ((outOfBoundsV)||(outOfBoundsH)){
          reverse(pickMove);
        }
        if((!outOfBoundsV)&&(!outOfBoundsH)){
          positionAvailability = checkForPositionAvailability(VerticalMove,HorizontalMove);
          if((!positionAvailability)){
            reverse(pickMove);
          }
        }
      } while ((outOfBoundsV)||(outOfBoundsH)||(!positionAvailability));
      // set the previous position to your current step of i:
      board[previousRow][previousColumn] = String.valueOf(i);
      board[VerticalMove][HorizontalMove] = "H";

      //update your previous position, with your current position
      previousColumn  = currentColumn;
      previousRow   = currentRow;
      boardPositions[VerticalMove][HorizontalMove] = true;
      displayBoard();
    }
  }