import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicSliderUI;

public class BasicSliderUIExt extends BasicSliderUI {

    public BasicSliderUIExt(JSlider slider) {
        super(slider);
    }

    @Override
    public void paintThumb(Graphics g) {
        if (isReady(super.slider)) {
            super.paintThumb(g); 
        }
    }

    @Override
    protected TrackListener createTrackListener(final JSlider slider) {
        return new TrackListener() {
            @Override
            public void mousePressed(MouseEvent event) {
                if (isReady(slider)) {
                    super.mousePressed(event);
                } else {
                    JSlider slider = (JSlider) event.getSource();
                    switch (slider.getOrientation()) {
                    case SwingConstants.VERTICAL:
                        slider.setValue(valueForYPosition(event.getY()));
                        break;
                    case SwingConstants.HORIZONTAL:
                        slider.setValue(valueForXPosition(event.getX()));
                        break;
                    }
                    super.mousePressed(event);
                    super.mouseDragged(event);
                }
            }

            @Override
            public boolean shouldScroll(int direction) {
                if (isReady(slider)) {
                    return super.shouldScroll(direction);
                }

                return false;
            }};
    }

    public static boolean isReady(JSlider slider) {
        Object ready = slider.getClientProperty(JSliderExt.READY_PROPERTY);
        return (ready == null) || (!(ready instanceof Boolean)) || (((Boolean) ready).booleanValue());
    }

}