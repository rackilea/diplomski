for(int i = beginx; i < CanvasWidth; i++)
{
    int x = i;
    int y = i * i; //x=y^2
    canvas.drawPoint(x, y, paint);
}