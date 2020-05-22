public class RecursiveListWordCount {

    public static void main(String[] args) {
        System.out.println(count(Arrays.asList("a", "b", "a", "b", "c"), "d"));
    }

    public static final int count(List<String> list, String word) {
        if(list.isEmpty()) {
            return 0;
        }

        if(list.get(0).equals(word)) {
            return 1 + count(list.subList(1, list.size()), word);
        } else {
            return 0 + count(list.subList(1, list.size()), word);
        }

    }
}