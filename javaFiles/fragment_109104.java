frame.addInternalFrameListener(new InternalFrameAdapter() {
    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        frame.getDesktopIcon().setLocation(frame.getLocation().x, frame.getLocation().y);
    }
});