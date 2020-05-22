int getNextSegment(int current) {
    int i = current;
    while(i < segments.length && segments[i] <= segments[current] + 2 * D)
        i++;
    return i - 1;
}