public class MyString {
    private final String s;
    public MyString(String s) {
        this.s = s;
    }
    public String replace(String search, String replace) {
        return s.replace(search, replace);
    }
}