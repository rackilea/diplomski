public class Adder {
    private BigInteger first;
    private BigInteger second;

    public Adder(BigInteger f, BigInteger s) {
        first = f;
        second = s;
    }

    public synchronized BigInteger getFirst() {
        return first;
    }

    public synchronized BigInteger getSecond() {
        return second;
    }

    public synchronized void update(BigInteger f, BigInteger s) {
        first = f;
        second = s;
    }

    public synchronized BigInteger add() {
        return first.add(second);
    }
}