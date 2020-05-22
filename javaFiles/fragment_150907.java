x = min(R, G, B);
V = max(R, G, B);
if (V == x) {
  H = UNDEFINED
  S = 0
}
else {
  if( R == x ) {
    f = G - B;
    i = 3;
  } else if( G == x ) {
    f = B - R;
    i = 5;
  } else {
    f = R - G;
    i = 1;
  }
  H = i - f /(V - x);
  S = (V - x)/V;
}