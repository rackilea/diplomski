System.out.println("Enter a maximum time: ");
double max = ITI1120.readDouble();
System.out.println("Enter a time step: ");
double h = ITI1120.readDouble();
// This is an array of length zero.
int n = (int)max/h + 1;
double [] t = new double[n];
int k = 0;
t[k] = 0.0;
while (t[k]<=max)
{
  k = k + 1;
  // There's no t[1] in a zero length array.
  t[k] = t[k-1] + h;
  System.out.println(t[k]);
}