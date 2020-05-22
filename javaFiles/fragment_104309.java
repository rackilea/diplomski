// Copying the value (only use if value is a constant, i.e. final)
class X {
    static String myStaticString = ViewPagerAdapter.myStaticString;
    void x() {
        String x = myStaticString;
    }
}