public class Map ... {
    private static int count = 0;

    public ... get(...) {
        count++;
        ...
    }

    public void put(...) {
        count++;
        ...
    }

    public static int getCount() {
        return count;
    }
}