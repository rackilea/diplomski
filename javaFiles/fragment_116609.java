public class PaintingMouseListener implements MouseListener {

    private final JPanel targetPanel;


    public PaintingMouseListener(JPanel targetPanel) {
        this.targetPanel = targetPanel;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        targetPanel.setMousePressed(true);

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        targetPanel.setMousePressed(false);
    }

    // other methods of the listener
}