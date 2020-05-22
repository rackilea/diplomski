public class ParameterSynchronizer <T> {

    private final CopyOnWriteArrayList<T> objects;
    private final ConcurrentHashMap<T, Integer> lockCounter;

    public ParameterSynchronizer(){
        objects = new CopyOnWriteArrayList<>();
        lockCounter = new ConcurrentHashMap<>();
    }

    public T getLockObject(T input){
        synchronized (objects) {
            T lock = input;
            int index = objects.indexOf(lock);
            if (index >= 0) {
                lock = objects.get(index);
                lockCounter.put(lock, lockCounter.get(lock)+1);
            } else {
                objects.add(lock);
                lockCounter.put(lock, 1);
            }
            return lock;
        }
    }

    public void cleanUpLockObject(T input){
        synchronized (objects) {
            T lock = input;
            int counter = lockCounter.get(lock);
            if(counter == 1) {
                objects.remove(objects.indexOf(lock));
                lockCounter.remove(lock);
            }else{
                lockCounter.put(lock, counter - 1);
            }
        }
    }

}