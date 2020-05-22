public final class InitItself {

    static {
        System.out.println("Class is loaded");
    }

    private static InitItself me = new InitItself();

    static {
        System.out.println("me is instantiated");
    }

    public InitItself() {
        System.out.println("Constructor called, me=" + me);
    }

    public static void main(String[] args) {
        System.out.println("START");
        InitItself i = new InitItself();
        System.out.println("FINISH");
    }
}