JFrame f = new JFrame("Test");
f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
while (true) {
    f.setVisible(true);
    f.setState(JFrame.NORMAL);
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}