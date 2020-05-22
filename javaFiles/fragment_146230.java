public interface ICamera {

    boolean supportsRegionOfInterest();

    void connect();

    void release();

    boolean isConnected();
}