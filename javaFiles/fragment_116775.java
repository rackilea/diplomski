Object obj = new Object() {
    void fn() {
        System.err.println("fn");
    }
    @Override public String toString() {
        fn();
        return "";
    } 
};
obj.toString();



new Object() {
    void fn() {
        System.err.println("fn");
    }
}.fn();


identity(new Object() {
    void fn() {
        System.err.println("fn");
    }
}).fn();
...
private static <T> T identity(T value) {
    return value;
}