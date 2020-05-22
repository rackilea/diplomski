class OnDiskList extends AbstractList<CharSequence> {

    // Slow list access method: Linear search for n:th line.
    @Override
    public CharSequence get(int n) {
        System.out.println("Fetching line " + n + "...");
        try (Stream<String> lines = Files.lines(Paths.get("big-file.txt"))) {
            return lines.skip(n).findFirst().get();
        } catch (IOException shouldBeHandled) {
            return null;
        }
    }

    @Override
    public int size() {
        return 5;
    }
}