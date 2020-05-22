public class CloneTest {

    public static <T> Set<T> clone(Set<T> set) {
        try {
            Set<T> cloned = set.getClass().newInstance();
            cloned.addAll(set);
            return cloned;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Set<String> test = new TreeSet<>();
        test.add("asd");
        printClone(clone(test));
        printClone(clone(new HashSet<>(test)));
    }

    public static void printClone(Set<?> set) {
        System.out.println(set.getClass().getSimpleName());
        set.forEach(System.out::println);
    }

}