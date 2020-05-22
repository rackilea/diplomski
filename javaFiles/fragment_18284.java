import android.graphics.Color;

public class ColorComponents implements OnColorChangedListener {
    void colorChanged(int color) {
        final int red = Color.red(color);
        final int green = Color.green(color);
        final int blue = Color.blue(color);
    }
}