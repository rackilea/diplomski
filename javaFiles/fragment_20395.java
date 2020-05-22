public class GenericPerformance {
    public static void main(final String[] args) {
        final Stuff<Integer> stuff = new IntStuff();
        final Integer data = stuff.getData();
        stuff.putData(data);
    }
}

interface Stuff<T> {
    T getData();
    void putData(T stuff);
}

class IntStuff implements Stuff<Integer> {
    private Integer stuff;
    public Integer getData() {
        return stuff;
    }
    public void putData(final Integer stuff) {
        this.stuff = stuff;
    }
}