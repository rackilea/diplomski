Button button = new Button("Click the button");
Label l = new Label();
try {
    List<String> lines = Files.lines(Paths.get("/temp/mantra.txt"))
        .skip(low)
        .limit(high - low)
        .collect(Collectors.toList());
    Random rng = new Random();
    button.setOnAction(evt -> l.setText(lines.get(rng.nextInt(lines.size()))));
} catch (IOException exc) {
    exc.printStackTrace();
}
// ...