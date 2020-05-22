import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.Appender;
import ch.qos.logback.core.AppenderBase;

public class SavingAppender<E> extends AppenderBase<E> {
    private final ThreadLocal<List<E>> events = new ThreadLocal<List<E>>() {
        protected List<E> initialValue() {
            return new ArrayList<>();
        }
    };

    protected void append(E event) {
        events.get().add(event);
    }

    public void clearLog() {
        events.get().clear();
    }

    public void writeLog(Appender<E> other) {
        for(E event:events.get()) {
            other.doAppend(event);
        }
    }
}