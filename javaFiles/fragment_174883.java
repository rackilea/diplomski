public class SpacesTest {

    public static void main(String[] args) {

        ParkingSpots ps = new ParkingSpots("Dummy", false, false);

        ParkingSpots[] spots = new ParkingSpots[9];

         spots[0] = new ParkingSpots("A1", false, false);
         spots[1] = new ParkingSpots("A2", false, false);
         spots[2] = new ParkingSpots("A3", false, false);
         spots[3] = new ParkingSpots("B1", false, false);
         spots[4] = new ParkingSpots("B2", false, false);
         spots[5] = new ParkingSpots("B3", false, false);
         spots[6] = new ParkingSpots("C1", false, true);
         spots[7] = new ParkingSpots("C2", false, true); 
         spots[8] = new ParkingSpots("C3", false, true);

         System.out.println(ps.coveredSearch(Arrays.asList(spots)));
    }    
}