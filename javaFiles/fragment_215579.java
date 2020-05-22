public abstract class ToastUtils {
      /**
       * Displays a toast message, making sure that the toast is always invoked from the main (ui) thread.
       * @param act Calling Activity
       * @param text Toast text
       * @param duration Toast duration
       */
      public static void showToast(final Activity act, final String text, final int duration) {
         act.runOnUiThread(new Runnable() {
            public void run() {
               Toast.makeText(act, text, duration).show();
            }
         });
      }
   }