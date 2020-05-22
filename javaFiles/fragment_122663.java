public class Test {
    public static void main(String... args) {
        checkInterned("ja", "va");
        checkInterned("ja", "va.lang");
        checkInterned("ja", "va.other");
        checkInterned("Int", "eger");
        checkInterned("abc", "def");
        checkInterned("Te", "st");
        checkInterned("Te", "st2");
        checkInterned("check", "Interned");
        checkInterned("check", "Interned2");
    }

    public static void checkInterned(String start, String end) {
        String x = start + end;
        String y = x.intern();
        System.out.println(x + " was interned already? " + (x != y));
    }
}