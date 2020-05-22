Arrays.sort(segments);
int current = -1;
for (int i = n-1; i >= 0; i--) {
    if (segments[i]-D <= 0) {
        current = i;
        break;
    }
}
if (current == -1) {
   System.out.println("Case #" + k + ": impossible");
   continue;
}
int count = 1;
boolean poss = true;
for (int i = segments[current]; i < L-D;) {
    count++;
    int next = getNextSegment(current);
    if (next == current) {
        poss = false;
        break;
    }
    current = next;
    i = segments[current];
}
if (!poss)
    System.out.println("Case #" + k + ": impossible");
else
    System.out.println("Case #" + k + ": " + count);