public int blackjack(int a, int b) {
// if both a and b are outside the valid range
if (a > 21 && b > 21)
  return 0;

// if a is within the valid range but b is not
if (a <= 21 && b > 21)
  return a;

// if b is within the valid range but a is not
if (b <= 21 && a > 21)
  return b;

// if both a and be are within the valid range
return (a-b >= 0) ? a : b;

// Alternative: return Math.max(a, b);    ---as per SimonT in the comment
}