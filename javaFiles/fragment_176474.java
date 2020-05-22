public class Bus {

    private final AtomicIntegerArray seats = new AtomicIntegerArray(50);
    private final AtomicInteger nextSeat = new AtomicInteger();

    public void bookSeat() throws Exception {
        // get the next value, then increment the sequence
        int next = nextSeat.getAndIncrement();
        // check if we don't exceed the size of the array 
        if (next < seats.length()){
            // Set the value at the index "next" to "1" for booked
            seats.set(next, 1);
            System.out.println("Seat number " +next+ " booked");
        } else {
            System.out.println("The bus is full sorry");
        }
    }
}