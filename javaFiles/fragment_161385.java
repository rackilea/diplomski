public class Dock {

    private Ship.ShipSize supportedSize;
    private Ship dockedShip = null;

    public Dock(Ship.ShipSize supportedSize) {
        this.supportedSize = supportedSize;
    }

    public Ship.ShipSize getSupportedSize() {
        return supportedSize;
    }

    public void setSupportedSize(Ship.ShipSize supportedSize) {
        this.supportedSize = supportedSize;
    }

    public Ship getDockedShip() {
        return dockedShip;
    }

    public void setDockedShip(Ship dockedShip) {
        this.dockedShip = dockedShip;
    }
}