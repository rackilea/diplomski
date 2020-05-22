Rect pos = new Rect();
for (int i = 0; i < mCols; i++) {
    pos = new Rect(mTiles[1][i].getmPos());
    pos.top = pos.top - size;
    pos.bottom = pos.bottom - size;
    mTiles[0][i].setmPos(pos);
}