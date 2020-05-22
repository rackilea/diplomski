public class VehicleDB {
    private int n;

    public VehicleDB(int n) {
        this.n = n;
    }
}

public class HoldenDB extends VehicleDB {

    public HoldenDB() {
        super(50);
    }
}