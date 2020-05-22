OnGlobalLayoutListener NumbersoGLL = new OnGlobalLayoutListener() {
@Override
public void onGlobalLayout() {

    xRLWInt = gBoard_RL.getWidth() / 2;
    yRLHInt = gBoard_RL.getHeight() / 2;
    xTint = gBoard_RL.getLeft() + xRLWInt;
    yTint = gBoard_RL.getTop() + yRLHInt;   

    path_em = new PathEM(this, xTint, yTint);
    gBoard_RL.addView(path_em);
    root_RL.addView(gBoard_RL);
  }
};