javafx.scene.paint.Color fx = ...;

java.awt.Color awtColor = new java.awt.Color((float) fx.getRed(),
                                             (float) fx.getGreen(),
                                             (float) fx.getBlue(),
                                             (float) fx.getOpacity());