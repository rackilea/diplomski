public class TheatreShow {
     List<Booking> booking = new ArrayList<>();

     public void addBooking(String forename, String surname, int numberOfSeats){
        booking.add(new Booking(forename, surname, numberOfSeats));
     }
}