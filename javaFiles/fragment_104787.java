public class Present implements PresentInterface {
    public static class CostComparator implements Comparator<Present >
    {
        public int compare(Present p1, Present p2)
        {
            // use either this line for null
            if (p1 == null || p2 == null) throw new NullPointerException();
            // or these 2 lines for null:
            if (p1 == null) return p2 == null ? 0 : -1;
            if (p2 == null) return 1;
            // and now do a reference check for speed
            if (p1 == p2) return 0;
            // and finally the value checks
            return Double.compare(p1.cost, p2.cost);
        }
    }
    private String name;
    private String type;
    private double cost;
}