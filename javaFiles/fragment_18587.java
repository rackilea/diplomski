private static void checkSurrounding(char[][] list, int x, int y) {
    for(int dx = -1; dx <= 1; dx++) {
        if ((x + dx >= 0) && (x + dx < list.length)) {
            for(int dy = -1; dy <= 1; dy++) {
                if ((y + dy >= 0) && (y + yd < list[x + dx].length) && (!(dx == 0 && dy == 0))) {
                    System.out.print(list[x + dx][y + dy]);
                }
            }
        }
    } 
}