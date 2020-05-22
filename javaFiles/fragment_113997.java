// shift a letter to another letter shftAmt spaces away
static char shift(int shftAmt, char c) {
  if (let2nat(c) < 0 || let2nat(c) > Z_TO_A - 1) {
     return c;
  } else {
     // do a safe shift
     int result = (let2nat(c) + shftAmt) % Z_TO_A;
     result += Z_TO_A;
     result %= Z_TO_A;
     return nat2let(result);
  }
}