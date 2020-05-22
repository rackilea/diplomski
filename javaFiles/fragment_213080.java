public static void main(String[] args) {
    System.out.println(new TestRecursion().strRecur("abc"));
}

public String strRecur(String s) {
    if(s.length() < 6) {
        return strRecur(s+"*");
    }
    return s;
}