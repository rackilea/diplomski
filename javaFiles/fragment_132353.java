public class ZoomListener implements ActionListener {
    private boolean zoomIn = false;
    private JSlider zoomSlider = null;
    private IconScaleManager iconScaleManager = null;

    public ZoomListener(boolean zoom, JSlider slider, IconScaleManager renderer) {
        zoomIn = zoom;
        zoomSlider = slider;
        iconScaleManager = renderer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        iconScaleManager.scaleButton(zoomIn);
        System.out.println(iconScaleManager.getScaleIndex());
        zoomSlider.setValue(iconScaleManager.getScaleIndex());
    }
}