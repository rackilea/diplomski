public class ColorPanel extends JPanel {

    public ColorPanel(Color color) {
        super.setBackground(color);
    }

    @Override
    public void setBackground(Color bg) {
        //blocked changing
    }

}