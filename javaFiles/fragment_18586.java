private static void checkSurrounding(char[][] list, int x, int y) {
    for(int dx = -1; dx <= 1; dx++) {
        for(int dy = -1; dy <= 1; dy++) {
            if(!(dx == 0 && dy == 0)) {
                System.out.print(list[x + dx][y + dy]);
            }
        }
    } 
}