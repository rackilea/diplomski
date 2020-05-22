public abstract class Player<T extends Unit> {

    private T unit;

    public Player(T unit) { }

    public T getUnit() {
        return unit;
    }

    public void setUnit(T unit) {
        this.unit = unit;
    }
}