public class EasyLocation extends android.location.Location {

    public EasyLocation(Location loc) {
        // copy data from loc to this.
        super(loc);
    }
    ...

    public long getElapsedTime() {
        return getTime() - System.currentTimeMillis();
    }
}