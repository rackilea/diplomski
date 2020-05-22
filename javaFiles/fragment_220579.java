List<Function<Integer, Integer>> algorithms = Arrays.asList(this::runInsertion, this::runSelection);
List<Color> colors = Arrays.asList(Color.blue, Color.black);

for (int i = 0; i < algorithms.size(); i++) {
    work(colors.get(i), algorithms.get(i));
}