public class Hall {

    public final Set<Seat> seats = new HashSet<>();

    public Set<Seat> getSeats() {
        return Collections.unmodifiableSet(seats);
    }

    public void createSeats(int lastRow, int seatsPerRow) { // This is an example; in case you have different count of seats per row, you better make an boolean addSeat(int row, int number) function; boolean to check if it has been added or if the seat already exists
        for (int row = 1; row <= lastRow; row++) {
            for (int number = 1; number <= seatsPerRow; number++) {
                seats.add(new Seat(row, number));
            }
        }
    }

    public Seat get(int row, int number) {
        for (Seat seat : seats) { // or you use seats.iterator; I personally hate Iterators; it is my subjective point of view.
            if (seat.is(row, number)) {
                return seat;
            }
        }
        return null;
    }

    public boolean reserve(int row, int number) {
        Seat seat = get(row, number);
        if (seat != null) {
            return seat.reserve();
        }
        return false;
    }
}