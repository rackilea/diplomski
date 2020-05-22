public double mean (LinkedList<? extends Number> l)
 {
  double sum = 0;
  int n = 0;
  for (Number i : l)
  {
   n++;
   sum += i.doubleValue();
  }

  return sum / n;
 }