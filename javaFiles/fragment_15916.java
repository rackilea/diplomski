private static void changeInteger(Wrapper x) {
    x = Wapper.valueOf(5);
}

public static void main(String[] args) {
    Wrapper x = Wrapper.valueOf(0);
    changeInteger(x);
    System.out.println(x);
}