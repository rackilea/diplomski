public void countUpAndDown(int start, int end) {
    System.out.println(start);
    if (end == start) return;
    countUpAndDown(start+1, end);
    System.out.println(start);
}