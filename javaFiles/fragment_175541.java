public static int calculateMaxScore() {
    int rowscore = 0;
     for(int row=1; row<8; row++)
     {
        if (calculateRowScore(row) > rowscore) {
          rowscore = calculateRowScore(row);
        }
     }
     return rowscore; 
  }