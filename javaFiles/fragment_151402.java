public class Super {
    Integer state = 0;

    Super f() {
        Super x = new Super();
        incrementState(x);
        return x;
    }

    protected void incrementState(Super x) {
        x.state = this.state + 1;
    }
}

public class Sub extends Super {
    Sub f() {
        Sub s = new Sub();
        incrementState(s);
        return s;
    }
}