private String value;

public Main() {
    this(10); // alternate constructor, super() isn't invoked yet.
}

public Main(int val) {
    this(String.valueOf(val)); // alternate constructor, no super() yet
}

public Main(String str) {
    // super(); // <-- will now implicitly or explicitly super()
    this.value = str;
}