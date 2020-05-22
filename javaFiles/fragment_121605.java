long mask = 0x03;
int npos = 0 ;
int cnt = 0;

for (int pos = 0; pos < 32; pos++, mask <<= 2) {

  if ((a & mask) == (b & mask)) {
     cnt++; // count how many matches
  } else {
    npos = pos ;  // *last* position that did not match
  }
}