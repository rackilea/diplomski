double c;

do {

  double a = floor(y);
  double aux = h1;
  h1 = a*h1+h2;
  h2 = aux;
  aux = k1;
  k1 = a*k1+k2;
  k2 = aux;
  y = 1/(y-a);

  if ((x-h1/k1) >= 0)
    c = x-h1/k1; 
  else
    c = -(x-h1/k1);

} while (c > x*limit );