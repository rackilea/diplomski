public class Foo5
{
    static class Recreate {

        private static ArrayList FEATURES = new ArrayList();

        public  enum Car {
          TESLA(FEATURES);
          Car(ArrayList l) { 
              System.out.println("car"); // *** Breakpoint ***
          }
        }
        public static Garage ONE_CAR_GARAGE = new Garage(Car.TESLA);

        public static class Garage {
            final Car car;

            Garage(Car car) {
              this.car = car;  // *** Breakpoint ***
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Recreate.Car car = Recreate.Car.TESLA;
        System.out.println(Recreate.Car.TESLA);
        System.out.println(Recreate.ONE_CAR_GARAGE.car.toString());
    }   
}