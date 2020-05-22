public static void main(final String[] args) throws Exception {
    final String input = "[\"text1\",\"text2\",\"text3\"]";
    final List<String> output = new ArrayList<>();
    for(final String item : input.replaceAll("^\\[\"|\"\\]$", "").split("\",\"")) {
        output.add(item);
    }
    for(final String item : output) {
        System.out.println(item);
    }
}