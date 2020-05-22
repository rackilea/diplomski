ellipse(325,325,15,15);      
for (int i = i; i < 25; i++)
{
  double div = i*6d;
  double radius = (i*20d);
  for (int j = 0; j < div; j++)
  {
    double theta = j * 360d / div;
    double x = 325d + (radius*cos(radians(theta)));
    double y = 325d + (radius*sin(radians(theta)));
    ellipse(x, y, 15, 15);
  }
}