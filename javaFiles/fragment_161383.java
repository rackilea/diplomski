import java.util.Arrays;

public class Ship {

    private String shipName;
    private ShipSize shipSize;
    public Ship(String shipName, ShipSize shipSize) {
        this.shipName = shipName;
        this.shipSize = shipSize;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public ShipSize getShipSize() {
        return shipSize;
    }

    public void setShipSize(ShipSize shipSize) {
        this.shipSize = shipSize;
    }

    public boolean isCargo() {
        return shipSize == ShipSize.CARGO;
    }

    public boolean isContainer() {
        return shipSize == ShipSize.CONTAINER;
    }

    public enum ShipSize {
        CARGO,
        CONTAINER;

        public static ShipSize of(String size) {
            return Arrays.stream(ShipSize.values()).filter(enumSize -> enumSize.name().equalsIgnoreCase(size)).findAny().orElse(null);
        }
    }
}