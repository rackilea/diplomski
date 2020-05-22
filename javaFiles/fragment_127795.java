class SmartPhone {
    private final Battery battery;
    private final String make, model;

    public SmartPhone(String make, String model, String bType, int bVoltage) {
        this.make = make;
        this.model = model;
        this.battery = new Battery(bType, bVoltage);
    }

    public String getMake() { return make; } 
    public String getModel() { return model; }

    public String getBatteryType() { return battery.getType(); }
    public int getBatteryVoltage() { return battery.getVoltage(); }
}