public class SeatReservationSystem {
    public static class ReservationFailedException {
        ... constructors taking a message ...
    }

    public static class SeatTakenException extends ReservationFailedException {
        ... constructors taking a message ...
    }

    public static class OutsideAgeException extends ReservationFailedException  {
        ... constructors taking a message ...
    }

    ....
}