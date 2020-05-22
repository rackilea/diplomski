int start = 0;
while (start < max) {       
    final int next = Math.min(start + INTERVAL_SIZE, max);
    for(int i = start; i < next; i++) {
        // loop-body using i
    }
    start = next;
}