/** @return true if this Ship contains the point */
    public boolean contains(int x, int y) {
        int myX = left; int myY = top;
        int xInc = (isHorizontal ? 1 : 0);
        int yInc = ((xInc+1)%2);

        for (int z = 0; z < size; z++) {
            if (myX == x && myY == y) {
                return true;
            }
            myX += xInc; myY += yInc;
        }
        return false;
    }