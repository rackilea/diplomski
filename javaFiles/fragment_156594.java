double tolerance = 0.0000007; // or whatever limit you want
double sin = 0.;
int n = 1;
double term = x;
while ( Math.abs(term) > tolerance ) {
  sin += term;
  term *= -( (x/(n+1)) * (x/(n+2)) );
  n+= 2;
}