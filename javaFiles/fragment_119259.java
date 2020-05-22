private void findMinMax(int x, int y) {
    if (x < mDrawnAreaRect.left) { //min x
        mDrawnAreaRect.left = x;
    }

    if (y >  mDrawnAreaRect.top) { //max y
        mDrawnAreaRect.top = y;
    }

    if (x >  mDrawnAreaRect.right) { //max x
        mDrawnAreaRect.right = x;
    }

    if (y <  mDrawnAreaRect.bottom) { //min y
        mDrawnAreaRect.bottom = y;
    }
}