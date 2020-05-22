public class Users {

    private List<List<String>> twoDList;

    public String get(int x, int y) {
        return twoDList.get(y).get(x);
    }

    public void set(int x, int y, String value) {
        twoDList.set(y, twoDList.get(y).set(x, value));
    }

    //etc.
}