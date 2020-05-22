public class WallService extends Service {

public native String stringFromJNI();
static {
    System.loadLibrary("native-lib");
}