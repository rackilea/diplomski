public class AndroidUtilities {

    public static float density = 1;
    public static int statusBarHeight = 0;
    public static Point displaySize = new Point();

    public static void init() {
        density = App.getInstance().getResources().getDisplayMetrics().density;
        checkDisplaySize();
    }

    // your other code
}