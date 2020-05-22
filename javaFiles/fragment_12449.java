public static void main(String[] args) throws AWTException {
    final Bootstrap b = new Bootstrap(new ScreenshotCapturer());
    b.beginCapture(new ScreenCaptureCallback() {
        @Override
        public void captureEnded(CapturedImage img) {
            b.beginCapture(new ScreenCaptureCallback() {
                @Override
                public void captureEnded(CapturedImage img) {
                    JFrame frame = new JFrame();
                    frame.add(new JLabel(new ImageIcon(img.getBufferedImage())));
                    frame.pack();
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            });
        }
    });
}