public class SysTime {
    public static SysTime INSTANCE = new SysTime();

    public long now() {
        return System.currentTimeMillis();
    }
}