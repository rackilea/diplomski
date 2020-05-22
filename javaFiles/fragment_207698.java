public class MCVE {

public static void main(String[] args) {
   // IMO list isn't very descriptive, so I changed it to carList.
   ArrayList<Car> carList = new ArrayList<>();

   // Add a bunch of values to carList here.

   for(int i = 0; i < carList.size(); i++) {
      if(carList.get(i).getStatus().equals("Departing")) {
         incrementTimesMoved(i, carList);
         return; // stops the method
      }
   }

}

// only static because I am calling in the main() function
private static void incrementTimesMoved(int index, ArrayList<Car> carList) {

   for(int i = 0; i < carList.size(); i++) {

      if(i == index) {
         carList.remove(index);
         return;
      }

      carList.get(i).setMoved(carList.get(i).getMoved() += 1);
   }
}

}