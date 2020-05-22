public class SomeClass {
    private JPanel createPanelFor(Vehicle vehicle) {
        return vehicle.accept(new VehicleVisitor<JPanel>() {
            @Override
            public JPanel visitCar(Car car) {
                return new CarPanel(car);
            }
            // same for Truck and Bike
        }
    }
}