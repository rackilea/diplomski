class BuildVehicleBooking {
    Long officeId;
    Long start;
    Long end;
    String origin;
    String destination;
    String purpose;             
    String requirements;
    Integer numberOfPassengers;

    Booking createVehicleBooking () throws ServiceException { ... }
}