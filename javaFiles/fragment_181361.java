int flushCounter = 0;

char s = hand.charAt(1); // s for suite
for (int i = 3; i < hand.length(); i = i + 2) {
  if (s == hand.charAt(i)) {
    flushCounter++;
  }
}

if (flushCounter >= 5) {
  return true;
} else {
  return false;
}