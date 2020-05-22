public class MainClass extends Observable {
    private final Collection<? extends LogDestination> logDestinations;

    public MainClass() {
        logDestinations = Collections.emptySet();
    }

    public MainClass(B b) {
        logDestinations = Collections.singleton(new TextFileLog(b));
    }

    public MainClass(C c) {
        logDestinations = Collections.singleton(new DatabaseLog(c));
    }

    public MainClass(B b, C c) {
        logDestinations = Arrays.asList(new TextFileLog(b), new DatabaseLog(c));
    }

    public void log(String update) {
        for (LogDestination logDestination : logDestinations) {
            logDestination.log(update);
        }
    }
}

interface LogDestination {
    public void log(String update);
}

class TextFileLog implements LogDestination {
    private final B b;

    public TextFileLog(B b) {
        this.b = b;
    }

    @Override
    public void log(String update) {
        // Save the update in the txt file
    }
}

class DatabaseLog implements LogDestination {
    private final C c;

    public DatabaseLog(C c) {
        this.c = c;
    }

    @Override
    public void log(String update) {
        // Save the update in a db row
    }
}