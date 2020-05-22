buttons[i] = new JButton(Integer.toString(i + 1)) {
    @Override
    public Dimension getPreferredSize() {
        Dimension naturalSize = super.getPreferredSize();
        int sideLength = Math.max(naturalSize.width, naturalSize.height);
        return new Dimension(sideLength, sideLength);
    }
};