class FirstAndLast {
    private int first, last, count;
    public FirstAndLast(int index) { first = last = index; count = 1;}
    public int getFirst() { return first; }
    public int getLast() { return last; }
    public int getCount() { return count; }
    public void setFirst(int index) { first = index; }
    public void setLast(int index) { last = index; }
    public void incrementCount() { count++; }
}