public class RandomList<T> {
    private List<T> list;
    private Class<T> clazz;

    public List<T> getList() {
        return list;
    }

    public RandomList (Class<T> clazz, int n) {
        this.clazz = clazz;
        list = new ArrayList<T>();

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        if (clazz.isAssignableFrom(Integer.class)) {
            for (int i = 0; i < n; i++) {
                Integer r = rand.nextInt();
                list.add(r);
            }
        }
        else {
            throw new IllegalArgumentException("Unsupported class: " + clazz.getName());
        }
    }
}