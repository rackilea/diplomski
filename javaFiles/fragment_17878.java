public abstract class State implements Comparable<State> {

    // ...

    @Override
    public int compareTo(State other) {
        if (getCost() > other.getCost()) {
            return -1;
        }
        if (getCost() < other.getCost()) {
            return 1;
        }
        return 0;
    }
}