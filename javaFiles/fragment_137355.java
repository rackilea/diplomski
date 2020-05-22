public Tire(int maxPressure) {
   this.maxPressure = maxPressure;
}

public final Tire defaultTire = new Tire(28);
tires.getOrDefault("Michelin", defaultTire).getPressure();