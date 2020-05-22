public class ThreadLocalFlag {

    private ThreadLocal<AtomicBoolean> flag;
    private List<AtomicBoolean> allValues = new ArrayList<AtomicBoolean>();

    public ThreadLocalFlag() {
        flag = new ThreadLocal<AtomicBoolean>() {
            @Override protected AtomicBoolean initialValue() {
                AtomicBoolean value = new AtomicBoolean();
                allValues.add(value);
                return value;
            }
        };
    }

    public boolean get() {
        return flag.get().get();
    }

    public void set(boolean value) {
        flag.get().set(value);
    }

    public void setAll(boolean value) {
        for (AtomicBoolean tlValue : allValues) {
            tlValue.set(value);
        }
    }
}