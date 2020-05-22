class SmartPhone {
    private final Battery battery;
    private final String make, model;

    public SmartPhone(String make, String model, Battery battery) {
        this.make = make;
        this.model = model;
        // defensive copy
        this.battery = new Battery(battery.getType(), battery.getVoltage());
    }

    public String getMake() { return make; } 
    public String getModel() { return model; }

    public Battery getBattery() {
        // defensive copy
        return new Battery(battery.getType(), battery.getVoltage());
    }
}