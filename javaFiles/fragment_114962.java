import android.graphics.Color;

public class LibraryClass {

    public static void yourFunction() {

        int rgb = Color.RED;

        // This also works
        // int rgb = 0xFF0000;

        float[] hsv = new float[3];

        Color.colorToHSV(rgb, hsv);
    }
}