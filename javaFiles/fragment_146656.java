public class ItemCountsListener implements ItemProcessListener<Object, Object> {

private static final AtomicLong count = new AtomicLong(1);

public void afterProcess(Object item, Object result) {
    count.getAndIncrement();
}

public void beforeProcess(Object item) {}
public void onProcessError(Object item, Exception e) {  }