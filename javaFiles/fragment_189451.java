private class Pair {
    private String processState;
    private int time;

    public Pair(int time, String processState) {
        this.time = time;
        this.processState = processState;
    }

    public int getTime() {
        return this.time;
    }

    public String getProcessState() {
        return this.processState;
    }
}