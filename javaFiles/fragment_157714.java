public class PulseAlert {

private static Border compound = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());
private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

public void runAlert() throws InterruptedException {
    final PulseWindow pulseWin = new PulseWindow(alertWindow());
    pulseWin.getWindow().addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent click) {
            if(SwingUtilities.isRightMouseButton(click)) {
                pulseWin.stopPulsing();
                pulseWin.destroyPulse();
            } else if(SwingUtilities.isLeftMouseButton(click) && pulseWin.isPulsing()) {
                pulseWin.stopPulsing();
            } else if(SwingUtilities.isLeftMouseButton(click) && !pulseWin.isPulsing()) {
                pulseWin.startPulsing();
            }
        }
        @Override
        public void mouseEntered(MouseEvent arg0) {}
        @Override
        public void mouseExited(MouseEvent arg0) {}
        @Override
        public void mousePressed(MouseEvent arg0) {}
        @Override
        public void mouseReleased(MouseEvent arg0) {}
    });
    try {
        pulseWin.startPulse();
    } catch (Exception e) {
        e.printStackTrace();
    }
    while(pulseWin.pulserActive()) {
        Thread.sleep(100);
    }
    System.out.println("done with second SW");
}

public static JWindow alertWindow() {
    System.out.println("Start");
    JWindow newWin = new JWindow();

    JPanel panel = new JPanel();
        panel.setBorder(compound);
        panel.setBackground(Color.RED);

    JLabel imgLbl = new JLabel("Enter Alert Msg Here!");
        imgLbl.setFont(new Font(null,Font.BOLD,16));

    panel.add(imgLbl);
    newWin.setContentPane(panel);
    newWin.pack();

    Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(newWin.getGraphicsConfiguration());
    int taskBar = scnMax.bottom;
    int x = screenSize.width - newWin.getWidth();
    int y = screenSize.height - taskBar - newWin.getHeight();
    newWin.setLocation(x,y);
    newWin.setVisible(true);

    return newWin;
}
}