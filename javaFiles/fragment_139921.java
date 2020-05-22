public class IdTracker {

    private TreeSet<Long> available;
    private TreeSet<Long> current;

    public IdTracker() {
        this.available = new TreeSet<Long>();
        this.current = new TreeSet<Long>();
    }

    public long getNextId() {
        //Check to see if this is the first time being called, setting initial id to 1
        if (available.isEmpty() && current.isEmpty()) {
            current.add(1L);
            return 1L;
        }

        //Check to see if we have any available values to use
        if (!available.isEmpty()) {
            //Remove from available and assign to current
            Long availableId = available.first();
            available.remove(availableId);
            current.add(availableId);
            return availableId;
        }

        //There are no available id's, get the highest current id and increment
        Long highestCurrentId = current.last();
        Long nextId = highestCurrentId + 1;
        current.add(nextId);
        return nextId;
    }

    public void removeId(long id) {
        //Remove from the current (if there) and place into available
        if (current.remove(id)) {
            available.add(id);
        } else {
            //Handle your failure case
        }
    }
}