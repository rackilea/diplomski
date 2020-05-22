int Weekcount()
{
  otpr = (hour_rate/2)+hour_rate;
  t_normal = normal*hour_rate;
  t_overt = overt*otpr;
  return (t_normal + t_overt); 
 }