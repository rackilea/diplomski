public enum Mode
{
    NO_ASYNC_TASK(1),
    NO_DOWNLOADED_DRAWABLE(2),
    CORRECT(3);

    private final int id;
    Mode(int id) { this.id = id; }
    public int getValue() { return id; }
}