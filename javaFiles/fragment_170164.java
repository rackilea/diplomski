public class Test {

    @SuppressWarnings("unchecked")
    public static <T> void swap(T[] arr, int index1, int index2) {
        // Need to add null check and index checks
        List<T> list = Arrays.asList(arr);
        Collections.swap(list, index1, index2);
        arr = (T[]) list.toArray();
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4, 5 };
        swap(arr, 1, 2);
        System.out.println(Arrays.asList(arr));
    }

}