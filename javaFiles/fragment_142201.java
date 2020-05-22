int mirrorx = (N-1)-x;
for(int i = Math.max(mirrorx-y, 0), j = Math.max(y-mirrorx, 0); i < N && j < N; i++, j++) {
    if(board[(N-1)-i][j]) {
        return false;
    }
}