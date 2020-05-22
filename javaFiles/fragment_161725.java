scrollPane.getVerticalScrollBar().setBackground(Color.BLACK);
scrollPane.getHorizontalScrollBar().setBackground(Color.BLACK);

scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
    @Override
    protected void configureScrollBarColors() {
        this.thumbColor = Color.BLACK;
    }
});