public class State {

    private boolean ex;
    private int calledTimes;

    public void setEx(boolean ex) {
        this.ex = ex;
    }

    public int getCalledTimes() {
        return calledTimes;
    }

    public void incrementCalledTimes() {
        calledTimes++;
    }

}