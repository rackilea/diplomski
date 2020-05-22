public static  ParkingTicket checkParking(Car car, ParkingMeter meter)
{
    //sanity check (bonus)
    if ((car == null) || (meter == null))
        return null;

    if(car.getMinutesParked() > meter.getMinutesPaid()){
        return new ParkingTicket(car, meter);
    }

    return null;
}