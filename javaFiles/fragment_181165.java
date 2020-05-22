public FadeMenu(String text) {
    super(text);
    engine.addTimingListener(new TimingListener() {
        @Override
        public void timingEvent() {
            // This condition is added here to stop animation when selected 
            if (!isSelected()) {
                repaint();
            }
        }
    });
}