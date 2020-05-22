NEXT POS = (0;0)
SAME X
NEXT POS = (1;1) // I dont get why the x (first value) changed to 1

 public void nextFreePos(Point currentPos){
        // display the OLD POS (x,y) <-- x = row and y = column
        System.out.println("OLD POS = ("+(currentPos.x)+";"+currentPos.y+")");       
        boolean stop = false;
        // check if there is a free Pos in current row, starting from current y
        for(int y = currentPos.y; y < 7; y++){
            // check if Position is free and no free position has been found yet
            if(matrix[currentPos.x][y] == 0 && stop == false){
                stop = true;
                System.out.println("SAME X");
                currentPos.y = y;
            }
        }