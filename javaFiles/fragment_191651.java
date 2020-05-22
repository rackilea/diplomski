public static void getNeighbours(ArrayList<Byte> nbrs, byte input, int bit, int maxDist) {
    if(maxDist == 0 || bit == 8) {
        nbrs.add(input);
    } else {
        getNeighbours(nbrs, (byte) (input^(1<<bit)), bit+1, maxDist-1);
        getNeighbours(nbrs, input, bit+1, maxDist);
    }
}