for (int i = hand.size() - 1; i >= 0; i--) {
   hand.remove(i);
}

while (hand.size() > 0) {
   hand.remove(hand.size() - 1);
   // or hand.remove(0); but this causes bad complexity bounds on an ArrayList
}