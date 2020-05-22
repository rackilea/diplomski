public Ball(double x, double y, double dia, Color c)
{
     super(x, y, dia, c);
     dx = Math.random()* 12 - 6;
     dy = Math.random() * 12 - 6;
     setX(getX() + dx); //add your x difference
     setY(getY() + dy); //add your y difference  
}