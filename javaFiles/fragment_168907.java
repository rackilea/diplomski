Collections.sort(hand);
int prev = hand.get(0);
int occursMost = hand.get(0);
int count = 1;
int maxCount = 1;

for (int i = 1; i < hand.length; i++) {
    if (a.get(i) == prev)
        count++;
    else {
        if (count > maxCount) {
            popular = a.get(i-1);
            maxCount = count;
        }
        prev = hand.get(i);
        count = 1;
    }
}
if(occursMost == Color.BLUE) {
    colorReturned = Color.BLUE;
}