private static int[] findStone(int stone) {

    int[] position = new int[2];

    for (int x = 0; x < 8; x++) {
        for (int y = 0; y < 6; y++) {

            if (gamefield[x][y] == stone) {
                position[0] = x;
                position[1] = y;

                return position;
            }
        }
    }
    return null; // if there's no given stone
}