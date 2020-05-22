public static String calculate(String str) {
    int x = 0;
    int y = 0;
    int[][] move = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    int dir = 0;

    for (char ch: str.toCharArray()) {
        if (ch == 'F') { 
            x += move[dir][0]; 
            y += move[dir][1]; 
        } else if (ch == 'L') {
            dir++;
        } else if (ch == 'R') {
            dir--;
        }
        dir = (dir + 4) % 4;
    }
 return "[" + x + ", " + y + "]";
 }