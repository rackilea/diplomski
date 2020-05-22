interface I {
    public static final int i = 1, ii = Test10.out("ii", 2), kk = Test10.out("kk", 3);
}
interface J extends I {
    int j = Test10.out("j", 3), jj = Test10.out("jj", 4);
}
interface K extends J {
    int k = Test10.out("k", 5);
}
class Test10 {
    public static void main(String[] args) {
        System.out.println(J.ii);
        System.out.println(K.j);
    }
    static int out(String s, int i) {
        System.out.println(s + "=" + i);
        return i;
    }
}