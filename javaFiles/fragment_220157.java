class MinSizePanel extends JPanel {

    public Dimension getPreferredSize() {
        Dimension original = super.getPreferredSize();
        TitledBorder titleBorder = (TitledBorder)((CompoundBorder)getBorder()).getInsideBorder();
        int width = (int)Math.max( original.getWidth(), 60 + (int)titleBorder.getMinimumSize(this).getWidth());
        return new Dimension( width, (int)original.getHeight() );
    }
}