static int[][] halfImage(int[][] orig){
    int[][] hi = new int[orig.length/2][orig[0].length/2];

    for(int r = 0, newr = 0; r < orig.length; r += 2, newr++){
        for(int c = 0, newc = 0; c < orig[0].length; c += 2, newc++){
            hi[newr][newc] = orig[r][c];
        }
    }

    return hi;
}