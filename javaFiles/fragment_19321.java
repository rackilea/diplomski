public class ThreadUtils {
     private static volatile boolean shutdown = false;
     /** called by main when the application is shutting down */
     public static void shutdown() {
         shutdown = true;
     }
     /** used by the various non-daemon threads to test for shutdown */
     public static boolean isShutdown() {
         return shutdown;
     }
 }