public abstract class Db<T extends Connection> {
    private int idx;
    private T t;
    public Db(int _idx) { 
        idx = _idx;
    }
    public void setT(T t) {
        this.t = t;
    }
    public abstract T connect();
}