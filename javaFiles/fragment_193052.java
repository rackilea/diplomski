Timer t = new Timer(10, new ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent e) {
        int xnow = AL1.getX() + 1;
        int ynow = AL1.getY();

        ynow = (int)(ynow + Math.sin(2 * Math.PI * (xnow / 50 F)) * 10);
        AL1.setLocation(xnow, ynow);
    }
});