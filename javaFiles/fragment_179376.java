@Override public void componentResized(ComponentEvent e) {
    if (e.getSource() == yourFrame) {

        yourInternalFrame1.setBounds(0, 0, yourFrame.getContentPane().getWidth() / 4, yourFrame.getContentPane().getHeight());
        yourInternalFrame2.setBounds(yourFrame.getContentPane().getWidth() / 4, 0, yourFrame.getContentPane().getWidth() / 2, yourFrame.getContentPane().getHeight() / 2);

        // and so on
        // also can use yourDesktopPane instead of yourFrame.getContentPane()

    }
}