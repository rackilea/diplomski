public class ObservableStream extends Observable {
    private final Queue<String> lines = new ConcurrentLinkedQueue<>();

    public void addLine(String line) {
        lines.add(line);
        setChanged();
        notifyObservers();
    }

    public String nextLine() {
        return lines.poll();
    }
}