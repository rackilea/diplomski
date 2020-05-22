public class SampleEvent {
    public enum Path {
        LEFT, RIGHT
    }

    // Member variable
    private Path path;

    // Constructor
    public SampleEvent(Path p) {
        path = p;
    }

    public Path getPath() {
        return path;
    }
}