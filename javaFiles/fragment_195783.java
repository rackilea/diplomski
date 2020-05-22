public class TestDrive {

    public static void main(String[] args) {
        Hall hall = new Hall();
        int lastRow = 15;
        int seatsPerRow = 10;
        hall.createSeats(lastRow, seatsPerRow);

        boolean reserved = hall.reserve(5, 9);
        System.out.println("Seat(Row=5, Number=9) is reserved: " + (reserved == hall.get(5, 9).isReserved()));

        boolean reservedAgain = hall.reserve(5, 9);
        System.out.println("Seat(Row=5, Number=9) cannot be reserved again: " + (reservedAgain != hall.get(5, 9).isReserved()));
    }
}