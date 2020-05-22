class Node {
    private int num;
    private long time;

    public Node() {
        num = MyNum.genRandom();
        time = Time.time();
    }

    @Override
    public String toString() {
        return "Number " + num + " Time " + time;
    }
}