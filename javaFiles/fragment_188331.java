while(scan.hasNextLine()==true && r<rows){  // 1
        for(int c = 0; c<columns;c++){          // 2
            maze[r][c]=scan.next();             // 3
        }                                       // 4
        r++;                                    // 5
    }                                           // 6