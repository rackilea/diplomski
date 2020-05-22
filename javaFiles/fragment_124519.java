public class GLDrawConstants {

    public static final FloatBuffer gradOrangeWhiteBuffer;
    public static final FloatBuffer vertexBuffer0_5;

private static final float vertices0_5[] = { 
        -0.5f, -0.5f,// Bottom Left
        0.5f, -0.5f,// Bottom right
        -0.5f, 0.5f,// Top Left
        0.5f, 0.5f// Top Right
    };

private static final float gradOrangeWhiteColor[] = {
        255/255f, 239/255f, 196/255f, 0f, // Bottom Left 
        255/255f, 239/255f, 196/255f, 0f, // Bottom right
        250/255f, 200/255f, 62/255f, 0.3f, // Top Left
        250/255f, 200/255f, 62/255f, 0.3f  // Top Right
    };

static {
        gradOrangeWhiteBuffer = WDUtils.floatBuffer(gradOrangeWhiteColor);
        vertexBuffer0_5 = WDUtils.floatBuffer(vertices0_5);
}

}