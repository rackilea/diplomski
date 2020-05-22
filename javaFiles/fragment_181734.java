public class RandomList<T> {
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public RandomList (Function<Random, T> creator, int n) {
        list = new ArrayList<T>();

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for (int i = 0; i < n; i++) {
            list.add(creator.apply(rand));
        }
    }
}