public class Demo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> nullableList = list.stream()
                .filter(m -> m > 2)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), filtered -> filtered.isEmpty() ? null : filtered
                ));
        System.out.println(nullableList);
    }
}