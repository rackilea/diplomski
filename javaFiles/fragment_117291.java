int getAbsoluteX(int x, int y, double theta)
{
   int x_new = (int)(x*Math.cos(theta) - y*Math.sin(theta));
   return x_new;
}

int getAbsoluteY(int x, int y, double theta) 
{
   int y_new = (int)(x*Math.sin(theta) + y*Math.cos(theta));
   return y_new;
}