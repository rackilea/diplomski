public class IconManager {
    private static IconManager _instance;
    private final long GUID = 0xab4dd61c5d004c18L;
    private PersistentObject store;
    private int iconCount;

    private IconManager() {
        store = PersistentStore.getPersistentObject(GUID);
        synchronized(store) {
            if(store.getContents() == null) {
                store.setContents(new Integer(0));
                store.commit();
            }
        }
        iconCount = ((Integer)store.getContents()).intValue();
    }

    public static IconManager getInstance() {
        if (_instance == null) {
            _instance = new IconManager();
        }
        return _instance;
    }

    public int getCount() {             
        return iconCount;
    }

    public void setCount(int count) {      
        iconCount = count;
        synchronized(store) {
            store.setContents(new Integer(iconCount));
            store.commit();
        }
    }
}