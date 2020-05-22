public class CarFactory {

    private static class BikeDefaultImpl implements Bike {

        private final String fooProp;
        private Wheel wheel;

        public BikeDefaultImpl(String fooProp) {
            this.fooProp = fooProp;
        }

        @Override
        public String getFooProp() {
            return fooProp;
        }

        @Override
        public Wheel getWheel() {
            return wheel;
        }
    }


    private static class WheelDefaultImpl implements Wheel {

        private final String barProp;
        private Bike bike;

        public WheelDefaultImpl(String barProp) {
            this.barProp = barProp;
        }

        @Override
        public String getBarProp() {
            return barProp;
        }

        @Override
        public Bike getBike() {
            return bike;
        }
    }


    public static Bike of(String bikeProp, String wheelProp) {
        BikeDefaultImpl bike = new BikeDefaultImpl(bikeProp);
        WheelDefaultImpl wheel = new WheelDefaultImpl(wheelProp);
        bike.wheel = wheel;
        wheel.bike = bike;
        return bike;
    }

}