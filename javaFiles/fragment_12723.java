public enum State {

private static Map<Integer,State> int2state = new HashMap<>();

undefined(0), x(1), o(2), c(3), a(4), l(5), d(6);
private int code;

State(int code) {   // executed for *each* enum constant
    this.code = code;
    int2state.put( code, this ); 
}

public int getCode() {
    return this.code;
}

public static State getState(int code) {
    return int2state.get(code);
}
}