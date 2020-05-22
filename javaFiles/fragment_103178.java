public class TextAndLevelFilter implements Filter {
    private static final int offValue = Level.OFF.intValue();
    private final int levelValue;

    private final Collection<String> prefixes = new LinkedList<>();

    public TextAndLevelFilter(Level level) {
        this.levelValue = level.intValue();
    }

    public void addPrefix(String prefix) {
        prefixes.add(prefix);
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        final String message = record.getMessage();
        for (String prefix : prefixes) {
            if (message.startsWith(prefix)) {
                return true;
            }
        }
        return record.getLevel().intValue() >= levelValue && levelValue != offValue;
    }
}