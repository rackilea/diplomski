public class MatchChecker {
    private static final String ANY_VALUE = new String("*");

    private final Map<Object, String> map = new HashMap<Object, String>();

    public void addMatch(Object object, String string) {
        map.put(object, string);
    }

    public void addAnyValueMatch(Object object) {
        map.put(object, ANY_VALUE);
    }

    public boolean matches(Object object, String string) {
        if (!map.contains(object)) {
            return false;
        }
        if (map.get(object) == ANY_VALUE || map.get(object).equals(string)) {
            return true;
        }
        return false;
    }
}