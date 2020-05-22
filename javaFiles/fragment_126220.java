public double getPhoneRates()
{
  final int freeminutes = 50;
  double chargeperminute = 0.10;
  double d = 0;
  if (b.regularService() == true)
  {
    if (b.getMinutes() <= 50) return 0;
    else d = b.getMinutes() - freeminutes;
    d *= chargeperminute;
    d += freeminutes;
  }
  return d;
}