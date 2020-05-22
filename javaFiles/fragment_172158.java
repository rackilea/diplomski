int maxRow = 0;
 int playNum = 0;
 for(int row = 0;row < score.length;row++)
 {
     int rowTotal = 0;
     for(int col = 0;col < score[row].length;col++) 
     {
         rowTotal += score[row][col];
     }
     if(rowTotal>maxRow)  
     {
         playNum = row;
         maxRow = rowTotal;
     }

 }
 System.out.println("Player " + (playNum + 1) + " is victorious with a score of " + maxRow);