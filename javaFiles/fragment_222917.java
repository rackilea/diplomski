JWindow window = new JWindow();
window.getContentPane().add(
    new JLabel("", new ImageIcon(new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif")), SwingConstants.CENTER));
window.setBounds(500, 150, 300, 200);
window.setVisible(true);
try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    e.printStackTrace();
}
window.setVisible(false);
JFrame frame = new JFrame();
frame.add(new JLabel("Welcome"));
frame.setVisible(true);
frame.setSize(300,100);
window.dispose();