class SomeService  {

    @Autowired
    private List<VehicleRepairService> vehicleRepairServices;


    public void doSomething(String vehicleId) {
        Vehicle vehicle = getVehicle(vehicleId);
        for(VehicleRepairService vehicleRepairService:vehicleRepairServices){
            if(vehicle.getClass().equals(vehicleRepairService.getType())){
                vehicleRepairService.repair(vehicle);
            }
        }
    }

    public Vehicle getVehicle(String id){
        return new Truck();
    }
}

interface VehicleRepairService<T extends Vehicle> {
    void repair(T vehicle);

    Class<T> getType();
}

class CarRepairService implements VehicleRepairService<Car> {

    public void repair(Car vehicle) {
    }

    @Override
    public Class<Car> getType() {
        return Car.class;
    }
}

class TruckRepairService implements VehicleRepairService<Truck> {

    public void repair(Truck vehicle) {
    }

    @Override
    public Class<Truck> getType() {
        return Truck.class;
    }
}