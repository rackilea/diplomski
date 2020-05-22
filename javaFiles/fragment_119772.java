/*
 * TabbedPaneTabbedPaneTabPainter.java %E%
 *
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
import com.sun.java.swing.plaf.nimbus.AbstractRegionPainter;

/**
 */
public final class Painter extends AbstractRegionPainter {
    //package private integers representing the available states that
    //this painter will paint. These are used when creating a new instance
    //of TabbedPaneTabbedPaneTabPainter to determine which region/state is being painted
    //by that instance.
    static final int BACKGROUND_ENABLED = 1;
    static final int BACKGROUND_ENABLED_MOUSEOVER = 2;
    static final int BACKGROUND_ENABLED_PRESSED = 3;
    static final int BACKGROUND_DISABLED = 4;
    static final int BACKGROUND_SELECTED_DISABLED = 5;
    static final int BACKGROUND_SELECTED = 6;
    static final int BACKGROUND_SELECTED_MOUSEOVER = 7;
    static final int BACKGROUND_SELECTED_PRESSED = 8;
    static final int BACKGROUND_SELECTED_FOCUSED = 9;
    static final int BACKGROUND_SELECTED_MOUSEOVER_FOCUSED = 10;
    static final int BACKGROUND_SELECTED_PRESSED_FOCUSED = 11;


    private int state; //refers to one of the static final ints above
    private PaintContext ctx;

    //the following 4 variables are reused during the painting code of the layers
    private Path2D path = new Path2D.Float();
    private Rectangle2D rect = new Rectangle2D.Float(0, 0, 0, 0);
    private RoundRectangle2D roundRect = new RoundRectangle2D.Float(0, 0, 0, 0, 0, 0);
    private Ellipse2D ellipse = new Ellipse2D.Float(0, 0, 0, 0);

    //All Colors used for painting are stored here. Ideally, only those colors being used
    //by a particular instance of TabbedPaneTabbedPaneTabPainter would be created. For the moment at least,
    //however, all are created for each instance.
    private Color color1 = decodeColor("nimbusOrange", 0.032459438f, -0.55535716f, -0.109803945f, 0);
    private Color color2 = decodeColor("nimbusOrange", 0.08801502f, 0.3642857f, -0.4784314f, 0);
    private Color color3 = decodeColor("nimbusOrange", 0.08801502f, -0.63174605f, 0.43921566f, 0);
    private Color color4 = decodeColor("nimbusOrange", 0.05468172f, -0.6145278f, 0.37647057f, 0);
    private Color color5 = decodeColor("nimbusOrange", 0.032459438f, -0.5953556f, 0.32549018f, 0);
    private Color color6 = decodeColor("nimbusOrange", 0.032459438f, -0.54616207f, -0.02352941f, 0);
    private Color color7 = decodeColor("nimbusOrange", 0.08801502f, -0.6317773f, 0.4470588f, 0);
    private Color color8 = decodeColor("nimbusOrange", 0.021348298f, -0.61547136f, 0.41960782f, 0);
    private Color color9 = decodeColor("nimbusOrange", 0.032459438f, -0.5985242f, 0.39999998f, 0);
    private Color color10 = decodeColor("nimbusOrange", 0.08801502f, 0.3642857f, -0.52156866f, 0);
    private Color color11 = decodeColor("nimbusOrange", 0.027408898f, -0.5847884f, 0.2980392f, 0);
    private Color color12 = decodeColor("nimbusOrange", 0.035931647f, -0.5553123f, 0.23137254f, 0);
    private Color color13 = decodeColor("nimbusOrange", 0.029681683f, -0.5281874f, 0.18039215f, 0);
    private Color color14 = decodeColor("nimbusOrange", 0.03801495f, -0.5456242f, 0.3215686f, 0);
    private Color color15 = decodeColor("nimbusOrange", 0.032459438f, -0.59181184f, 0.25490195f, 0);
    private Color color16 = decodeColor("nimbusOrange", 0.05468172f, -0.58308274f, 0.19607842f, 0);
    private Color color17 = decodeColor("nimbusOrange", 0.046348333f, -0.6006266f, 0.34509802f, 0);
    private Color color18 = decodeColor("nimbusOrange", 0.046348333f, -0.60015875f, 0.3333333f, 0);
    private Color color19 = decodeColor("nimbusOrange", 0.004681647f, -0.6197143f, 0.43137252f, 0);
    private Color color20 = decodeColor("nimbusOrange", 7.13408E-4f, -0.543609f, 0.34509802f, 0);
    private Color color21 = decodeColor("nimbusOrange", -0.0020751357f, -0.45610264f, 0.2588235f, 0);
    private Color color22 = decodeColor("nimbusOrange", 5.1498413E-4f, -0.43866998f, 0.24705881f, 0);
    private Color color23 = decodeColor("nimbusOrange", 5.1498413E-4f, -0.44879842f, 0.29019606f, 0);
    private Color color24 = decodeColor("nimbusOrange", 5.1498413E-4f, -0.08776909f, -0.2627451f, 0);
    private Color color25 = decodeColor("nimbusOrange", 0.06332368f, 0.3642857f, -0.4431373f, 0);
    private Color color26 = decodeColor("nimbusOrange", 0.004681647f, -0.6198413f, 0.43921566f, 0);
    private Color color27 = decodeColor("nimbusOrange", -0.0022627711f, -0.5335866f, 0.372549f, 0);
    private Color color28 = decodeColor("nimbusOrange", -0.0017285943f, -0.4608264f, 0.32549018f, 0);
    private Color color29 = decodeColor("nimbusOrange", 5.1498413E-4f, -0.4555341f, 0.3215686f, 0);
    private Color color30 = decodeColor("nimbusOrange", 5.1498413E-4f, -0.46404046f, 0.36470586f, 0);
    private Color color31 = decodeColor("nimbusOrange", -0.57865167f, -0.6357143f, -0.54901963f, 0);
    private Color color32 = decodeColor("nimbusOrange", -4.2033195E-4f, -0.38050595f, 0.20392156f, 0);
    private Color color33 = decodeColor("nimbusOrange", 0.0013483167f, -0.16401619f, 0.0745098f, 0);
    private Color color34 = decodeColor("nimbusOrange", -0.0010001659f, -0.01599598f, 0.007843137f, 0);
    private Color color35 = decodeColor("nimbusOrange", 0.0f, 0.0f, 0.0f, 0);
    private Color color36 = decodeColor("nimbusOrange", 0.0018727183f, -0.038398862f, 0.035294116f, 0);
    private Color color37 = decodeColor("nimbusRed", 0.0f, 0.0f, 0.0f, 0);


    //Array of current component colors, updated in each paint call
    private Object[] componentColors;

    public Painter(int state) {
        super();
        this.state = state;
        Insets insets = null;
        switch( state ) {
            case BACKGROUND_ENABLED:                   insets = new Insets(7, 7, 1, 7); break;
            case BACKGROUND_ENABLED_MOUSEOVER:         insets = new Insets(7, 7, 1, 7); break;
            case BACKGROUND_ENABLED_PRESSED:           insets = new Insets(7, 6, 1, 7); break;
            case BACKGROUND_DISABLED:                  insets = new Insets(6, 7, 1, 7); break;
            case BACKGROUND_SELECTED_DISABLED:         insets = new Insets(7, 7, 0, 7); break;
            case BACKGROUND_SELECTED:                  insets = new Insets(7, 7, 0, 7); break;
            case BACKGROUND_SELECTED_MOUSEOVER:        insets = new Insets(7, 9, 0, 9); break;
            case BACKGROUND_SELECTED_PRESSED:          insets = new Insets(7, 9, 0, 9); break;
            case BACKGROUND_SELECTED_FOCUSED:          insets = new Insets(7, 7, 3, 7); break;
            case BACKGROUND_SELECTED_MOUSEOVER_FOCUSED:insets = new Insets(7, 9, 3, 9); break;
            case BACKGROUND_SELECTED_PRESSED_FOCUSED:  insets = new Insets(7, 9, 3, 9); break;
        }
        this.ctx = new AbstractRegionPainter.PaintContext(insets, new Dimension( 10  , 20 ), false );
    }

    @Override
    protected void doPaint(Graphics2D g, JComponent c, int width, int height, Object[] extendedCacheKeys) {
        //populate componentColors array with colors calculated in getExtendedCacheKeys call
        componentColors = extendedCacheKeys;
        //generate this entire method. Each state/bg/fg/border combo that has
        //been painted gets its own KEY and paint method.
        switch(state) {
            case BACKGROUND_ENABLED: paintBackgroundEnabled(g); break;
            case BACKGROUND_ENABLED_MOUSEOVER: paintBackgroundEnabledAndMouseOver(g); break;
            case BACKGROUND_ENABLED_PRESSED: paintBackgroundEnabledAndPressed(g); break;
            case BACKGROUND_DISABLED: paintBackgroundDisabled(g); break;
            case BACKGROUND_SELECTED_DISABLED: paintBackgroundSelectedAndDisabled(g); break;
            case BACKGROUND_SELECTED: paintBackgroundSelected(g); break;
            case BACKGROUND_SELECTED_MOUSEOVER: paintBackgroundSelectedAndMouseOver(g); break;
            case BACKGROUND_SELECTED_PRESSED: paintBackgroundSelectedAndPressed(g); break;
            case BACKGROUND_SELECTED_FOCUSED: paintBackgroundSelectedAndFocused(g); break;
            case BACKGROUND_SELECTED_MOUSEOVER_FOCUSED: paintBackgroundSelectedAndMouseOverAndFocused(g); break;
            case BACKGROUND_SELECTED_PRESSED_FOCUSED: paintBackgroundSelectedAndPressedAndFocused(g); break;

        }
    }



    @Override
    protected final PaintContext getPaintContext() {
        return ctx;
    }

    // ... paintBackgroundEnabled( ...
    // ...
}