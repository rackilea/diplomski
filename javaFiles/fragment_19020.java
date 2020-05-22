class ParkingLot{
   private ArrayList<Cars> spots;

   public boolean park(int spotNumber, Car car){          
       if( spots.get(spotNumber)==null){
            spot.set(spotNumber,car);
            return true;
       }
       return false;
   }
}