Cell[][] maze; // prepopulate with cells in a rectangular fashion. 
                // Populate adjacent cells with walls.
 {
     maze = new Cell[m][n];
     for (i = 0 .. m) {
         for (j = 0 .. n) {
             cell = maze[i][j] = new Cell(m, n);

             // fix top wall
             if (i == 0) { // first row
                 cell.wall[0] = new Wall();
                 cell.wall[0].setIsEdge();
             } else {
                 cell.wall[0] = maze[i-1][j].wall[2]; // my up is last row's down
             }

             // fix bottom wall
             cell.wall[2] = new Wall();
             if (i == m-1) { // last row
                 cell.wall[2].setIsEdge();
             }

             // fix left wall
             if (j == 0) { // leftmost column
                 cell.wall[3] = new Wall();
                 cell.wall[3].setIsEdge();
             } else {
                 cell.wall[3] = maze[i][j-1].wall[1]; // my left is last col's right
             }

             // fix right wall
             cell.wall[1] = new Wall();
             if (j == n-1) { // rightmost column
                 cell.wall[1].setIsEdge();
             }
         }
     }
 }

 List walls = new List();

 class Cell {
     Wall[] walls = new Wall[4]; // 0 is up, 1 is right, 2 is down, 3 is left (count clockwise)
     boolean isInMaze = false;
     int x;
     int y;
     Cell(col, row) {
         x = col;
         y = row;
     }
 }

 class Wall {
     boolean isOpen = false; // open walls are passages
     boolean isEdge = false; // edges have nothing on the other side.
     Cell[] cells = new Cell[2];
 }

 Cell aCell = maze[randomx][randomy]; // make sure x,y in bounds
 initializeCellInMaze(aCell, null);

 while (!walls.isEmpty()) {
    aWall = walls.get(randomWall); // in range
    if (!(aWall.cell[0].isInMaze && aWall.cell[1].isInMaze)) {
        // opposite cell NOT in maze
        wall.setIsOpen();
        Cell otherCell;
        if (wall.cell[0].isInMaze) {
            otherCell = wall.cell[1];
        } else {
            otherCell = wall.cell[0];
        }
        initializeCellInMaze(otherCell, aWall);
    }
    walls.remove(aWall); // or use index
 }

 initializeCellInMaze(cell, wallToSkip) {
     cell.setIsInMaze();
     for (i = 0 .. 3) if (cell.wall[i] != wallToSkip) walls.add(cell.wall[i]);
 }