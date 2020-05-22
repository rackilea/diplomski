import java.awt.Color;

public enum Colors{
    BLACK   (  0,   0,   0),
    BLUE    (  0,   0, 255), LIGHT_BLUE    (  0, 128, 255), DARK_BLUE    (  0,   0, 128),
    BROWN   (160,  96,   0), LIGHT_BROWN   (208, 144,   0), DARK_BROWN   ( 96,  32,   0),
    CYAN    (  0, 255, 255), LIGHT_CYAN    (176, 255, 255), DARK_CYAN    (  0, 139, 139),
    GRAY    (128, 128, 128), LIGHT_GRAY    (211, 211, 211), DARK_GRAY    ( 64,  64,  64),
    GREY    (128, 128, 128), LIGHT_GREY    (211, 211, 211), DARK_GREY    ( 64,  64,  64),
    GREEN   (  0, 255,   0), LIGHT_GREEN   (128, 255, 128), DARK_GREEN   (  0, 128,   0),
    MAGENTA (255,   0, 255), LIGHT_MAGENTA (255, 144, 255), DARK_MAGENTA (144,   0, 144),
    MINT    ( 96, 221,  96), LIGHT_MINT    (208, 238, 208), DARK_MINT    ( 16, 187,  16),
    ORANGE  (255, 128,   0), LIGHT_ORANGE  (255, 176,  48), DARK_ORANGE  (192,  64,   0),
    PINK    (255, 192, 203), LIGHT_PINK    (255, 128, 255), DARK_PINK    (231,  84, 128),
    RED     (255,   0,   0), LIGHT_RED     (255, 128, 128), DARK_RED     (128,   0,   0),
    YELLOW  (255, 255,   0), LIGHT_YELLOW  (255, 255, 128), DARK_YELLOW  (160, 160,   0),
    WHITE   (255, 255, 255);

    private int iRed;
    private int iGreen;
    private int iBlue;

    Colors(int iRed, int iGreen, int iBlue) {
        this.iRed   = iRed;
        this.iGreen = iGreen;
        this.iBlue  = iBlue;
    }

    public static Color fromString(String text) {
        if (text != null) {
            Colors ret = Colors.valueOf(text.toUpperCase());
            return new Color (ret.iRed, ret.iGreen, ret.iBlue);
        }
        return null;
    }
}