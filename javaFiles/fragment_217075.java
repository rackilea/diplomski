import org.tanukisoftware.wrapper.WrapperManager;

public class LoginServiceDefer {
    public static String svc = "loginservice";
    public static int ctrl   = 155;

    public static void main(String[] args) {
        System.out.println("Sending user control code.");
        try {
            WrapperManager.sendServiceControlCode(svc, ctrl);
            WrapperManager.stop(0);
        } catch (Exception re) {
            System.err.println("System error. Unable to send control code to service, " + svc + ", with control code, " + ctrl + ".");
            re.printStackTrace();
            WrapperManager.stop(1);
        }
    }
}