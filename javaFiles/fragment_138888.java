public class VehicleFactory {
    private static final VehicleFactory INSTANCE= new VehicleFactory();

    private VehicleFactory() {}

    public static VehicleFactory getInstance() { return INSTANCE; }

    public static Vehicle createVehicle(String data) {
        Vehicle value = null;
        String [] tokens = data.split("~");
        if ((tokens != null) && (tokens.length > X)) {
            // Map String to int or Date here
            value = new Vehicle(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
        }
        return value;
    }

    public static List<Vehicle> createVehicles(File f) {
        List<Vehicle> values = new ArrayList<Vehicle>();
        // implementation left for you
        return values;
    }
}