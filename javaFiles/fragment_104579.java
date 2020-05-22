boolean [] output = new boolean[rgbarr.length];
for ( int i=0; i<rgbarr.length; ++i ) {
  int a = (rgbarr[i] >> 24 ) & 0x0FF;
  int r = (rgbarr[i] >> 16 ) & 0x0FF;
  int g = (rgbarr[i] >> 8  ) & 0x0FF;
  int b = (rgbarr[i]       ) & 0x0FF;
  output[i] = (0.30*r + 0.59*g + 0.11*b) > 127;
}