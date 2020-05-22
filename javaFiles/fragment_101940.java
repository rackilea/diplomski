public static void main(String[] args) {
    Singleton.INSTANCE.method();
}

public enum Singleton {
    INSTANCE;
    public void method() {
        System.out.println(this);
    }
}