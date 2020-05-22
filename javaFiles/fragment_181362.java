int flushCounter = 0;
char s; // s for suite

for (int i = 1; i < hand.length(); i = i + 2) {
  if (i == 1) {
    s = hand.charAt(1); 
  } else if (s == hand.charAt(i)) {
    flushCounter++;
  }
}

if (flushCounter >= 5) {
  return true;
} else {
  return false;
}