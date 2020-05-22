public class ColorCheckBox extends JCheckBox {

    private Color unselectedColor;
    private Color selectedColor;

    public ColorCheckBox(Color unselectedColor, Color selectedColor) {
        this.unselectedColor = unselectedColor;
        this.selectedColor = selectedColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (isSelected()) {
            g.setColor(selectedColor);
        } else {
            g.setColor(unselectedColor);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
    }

}