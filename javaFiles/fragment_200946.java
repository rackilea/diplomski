public class App {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        List<String> file1 = Arrays.asList("aap", "noot", "aap", "wim", "vuur", "noot", "wim");
        List<String> file2 = Arrays.asList("aap", "noot", "mies", "aap", "zus", "jet", "aap", "wim", "vuur");
        List<String> file3 = Arrays.asList("noot", "mies", "wim", "vuur");

        System.out.println(getCommonWords(file1, file2, file3));
    }

    @SafeVarargs
    private final Set<String> getCommonWords(List<String>... files) {
        Set<String> result = new HashSet<>();
        // possible optimization sort files by ascending size
        Iterator<List<String>> it = Arrays.asList(files).iterator();
        if (it.hasNext()) {
            result.addAll(it.next());
        }
        while (it.hasNext()) {
            Set<String> words = new HashSet<>(it.next());
            result.retainAll(words);
        }
        return result;
    }
}