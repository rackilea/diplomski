public void setCapacity(int capacity) {
    if (this.capacity < capacity) {
        this.capacity = capacity;
    } else
        System.out.println("The capacity you entered is lower than the current capacity");
}