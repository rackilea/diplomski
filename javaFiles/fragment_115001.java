class Kernal {
    private int capacity;

    public void setCapacity(int newCapacity) {
        if(newCapacity < capacity) {
            throw new IllegalArgumentException("You cannot enter a value that is lower than the current capacity");
        }

        capacity = newCapacity;
    }
}