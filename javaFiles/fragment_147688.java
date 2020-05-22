final Color myColor = new Color(getDisplay(), 102, 255, 102);
myLabel.setForeground(color);
myLabel.addDisposeListener(new DisposeListener() {
    public void widgetDisposed(DisposeEvent e)
    {
        myColor.dispose();
    }
});