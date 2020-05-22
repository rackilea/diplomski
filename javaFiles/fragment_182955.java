interface Transport {}

enum Bus implements Transport {
    A, B, C
}

enum Train implements Transport {
    L, U, V
}

public class Test<T extends Enum & Transport> {
    private T transport;

    Test(T transport) {
        this.transport = transport;

        // Can still use enum methods
        System.out.println(this.transport.name());
        System.out.println(this.transport.ordinal());
    }

    public static void main(String[] args) {
        new Test(Train.L); // prints out "L", "0"
    }
}