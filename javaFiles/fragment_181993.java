public enum VehicleType {
    Car {
        @Override
        public ObjectProcessor createImpl() {
            return new CarImpl();
        }
    },
    Van {
        @Override
        public ObjectProcessor createImpl() {
            return new VanImpl();
        }
    };
    public abstract ObjectProcessor createImpl();
}

public void caller(VehicleType vehicleType, List<String> vehicleNames ) {
    ObjectProcessor processor = vehicleType.createImpl();
    processor.process(vehicleNames);
}