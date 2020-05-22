class T {
    public static void main(String[] args) {
        String[] words = "hello world hello-world".split("[-\\s]");
        for (String word : words) {
            System.out.println(word);
        }
    }
}