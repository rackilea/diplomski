public class LimitedLengthCollection extends MyCollection {
    @Override
    public void add(String s) {
        if (s.length() == 5) {
            super.add(s);
        }
    }
}