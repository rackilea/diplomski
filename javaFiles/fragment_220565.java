private boolean isPlayerVisible = false;
private int playerPosX;
private int playerPosY;

@Overrides
public void onDraw(Canvas canvas) {
    c = canvas;
    canvas.drawLine(0, 50, 100, 50, paint);
    if (isPlayerVisible) {
       Paint paint= new Paint();
       paint.setColor(0xFFFFFFFF);
       paint.setStrokeWidth(1);
       c.drawCircle(playerPosX, playerPosY, 5, paint);
    }
}    

private void setPlayersPos(int x, int y) {
  playerPosX = x;
  playerPosY = y;
  isPlayerVisible= true;
  invalidate();
}