long resultLo = (num1.mant & 0xFFFFFFFFL)+(num2.mant & 0xFFFFFFFFL);
long resultHi = (num1.mant >>> 32)+(num2.mant >>> 32)+(resultLo >>> 32);
result.exp = num1.exp; // Should match num2.exp
if (resultHi > 0xFFFFFFFFL) {
  exponent++;
  resultHi = (resultHi + ((resultHi & 2)>>>1)) >>> 1; // Round the result
}
rest.mant = (resultHi << 32) + resultLo;