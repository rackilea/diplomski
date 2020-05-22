java.awt.Color awtColor = ... ;
int r = awtColor.getRed();
int g = awtColor.getGreen();
int b = awtColor.getBlue();
int a = awtColor.getAlpha();
double opacity = a / 255.0 ;
javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(r, g, b, opacity);