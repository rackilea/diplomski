public class IntPair {
    private final int first;
    private final int second;

    public IntPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.first;
        hash = 89 * hash + this.second;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IntPair other = (IntPair) obj;
        if (this.first != other.first) {
            return false;
        }
        if (this.second != other.second) {
            return false;
        }
        return true;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }


}