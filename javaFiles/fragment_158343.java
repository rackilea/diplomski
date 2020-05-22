public class ListWrapper {

    private final ArrayList<String> theList = new ArrayList<String>();
    private final ReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();    

    public String read() {
        r.lock();
        try {
            System.out.println("reading");
            if(theList.isEmpty()) {
                return null;
            }
            else {
                return theList.get(0);
            }
        } finally {
            r.unlock();
        }
    }

    public void write(String data) {
        w.lock();
        try {
            System.out.println("Written " + data);
            theList.add(data);
        } finally{
            w.unlock();
        }
    }
}