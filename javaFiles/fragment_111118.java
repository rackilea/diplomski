import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.platform.win32.Kernel32;


public class RumbaConnect {


     public interface ehlapi32 extends Library {
         ehlapi32 ehlapi32 = (ehlapi32) Native.loadLibrary(
                (Platform.isWindows() ? "ehlapi32" : "ehlapi32"), ehlapi32.class);
            public int WD_ConnectPS(int hInstance , String ShortName);
            public int WD_SendKey(int hInstance, String KeyData);
        }
    public static final ehlapi32 ehlapi32 = (ehlapi32) Native.loadLibrary("ehlapi32", ehlapi32.class);   
    public static final Kernel32 kernel32 = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);



     public static void main(String[] args) {
         int process = 0; 
         int status = 0; 
         int intResult = 0; 

         process = kernel32.GetCurrentProcessId();
         status = ehlapi32.WD_ConnectPS(process, "A");
         intResult = ehlapi32.WD_SendKey(process, "MYNAME");
            System.out.println("Your Rumba Status: " + status);

     }
    /*  0  The function was successful  
        1  An incorrect PSID was specified  
        8  No prior call to Start Communication Notification (80) function was called for the PSID  
        9  A system error was encountered  
    */
}