private static boolean checkRow(int r0, int c0, int dr, int dc, int len, int num) {
    for (int k = 0 ; k != len ; k++) {
        int r = r0 + k*dr;
        int c = c0 + k*dc;
        if (r < 0 || c < 0 || r >= intersections.length || c > intersections[r].length || intersections[r][c] != num) {
            return false;
        }
    }
    return true;
}