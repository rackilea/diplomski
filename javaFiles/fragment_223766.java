interface Hi {
    void sayHi();
}

public static Hi asHi(final A target) {
    return new Hi() { public void sayHi() { // More concise from Java SE 8...
        target.sayHi();
    }};
}
public static Hi asHi(final B target) {
    return new Hi() { public void sayHi() { // More concise from Java SE 8...
        target.sayHi();
    }};
}