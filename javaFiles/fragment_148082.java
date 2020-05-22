import org.lwjgl.input.Mouse;

public class DebugHelper {
    public static boolean restoreMouse() {
        Mouse.setGrabbed(false);
        return true;
    }
}