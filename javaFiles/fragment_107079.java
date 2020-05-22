public class EasyLocation {

    Location loc;

    public EasyLocation(Location loc) {
        this.loc = loc;
    }

    public long getElapsedTime() {
        return getTime() - System.currentTimeMillis();
    }

    public Location getLocation() {
        return loc;
    }
}