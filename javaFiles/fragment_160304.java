public class BusyCursorTest extends javax.swing.JFrame {

private javax.swing.JPanel cursorPanel = null;

public BusyCursorTest() {

    javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
    javax.swing.JMenu menu = new javax.swing.JMenu("Menu");
    javax.swing.JMenuItem wait1 = new javax.swing.JMenuItem("Wait 100 ms");
    javax.swing.JMenuItem wait2 = new javax.swing.JMenuItem("Wait 250 ms");
    javax.swing.JMenuItem wait3 = new javax.swing.JMenuItem("Wait 500 ms");
    javax.swing.JMenuItem wait4 = new javax.swing.JMenuItem("Wait 1000 ms");
    menu.add(wait1);
    menu.add(wait2);
    menu.add(wait3);
    menu.add(wait4);
    menuBar.add(menu);
    setJMenuBar(menuBar);
    wait1.addActionListener(getActionListener(this, delayActionListener(100)));
    wait2.addActionListener(getActionListener(this, delayActionListener(250)));
    wait3.addActionListener(getActionListener(this, delayActionListener(500)));
    wait4.addActionListener(getActionListener(this, delayActionListener(1000)));

    cursorPanel = new javax.swing.JPanel();
    cursorPanel.addMouseListener(new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent e) {
            cursorPanel.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            cursorPanel.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.DEFAULT_CURSOR));
        }

    });

    javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
    tabbedPane.addTab("Default", new javax.swing.JPanel());
    tabbedPane.addTab("Cursor change", cursorPanel);
    getContentPane().add(tabbedPane);

    setTitle("Cursor test");
    setSize(400, 400);
    setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
}

private java.awt.event.ActionListener delayActionListener(final int delay) {
    java.awt.event.ActionListener listener = new java.awt.event.ActionListener() {

        public void actionPerformed(java.awt.event.ActionEvent ae) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }

    };
    return listener;
}

public static void main(String[] args) {
    new BusyCursorTest();
}

public static java.awt.event.ActionListener getActionListener(final javax.swing.JFrame frame,
    final java.awt.event.ActionListener originalActionListener) {

    java.awt.event.ActionListener actionListener = new java.awt.event.ActionListener() {

        public void actionPerformed(final java.awt.event.ActionEvent e) {

            java.util.TimerTask timerTask = new java.util.TimerTask() {

                public void run() {
                    originalCursor = frame.getCursor();
                    startWaitCursor(frame);
                }

            };
            java.util.Timer timer = new java.util.Timer();

            try {
                timer.schedule(timerTask, DELAY_MS);
                originalActionListener.actionPerformed(e);
            } finally {
                timer.cancel();
                stopWaitCursor(frame);
            }
        }

    };
    return actionListener;
}

private static void startWaitCursor(javax.swing.JFrame frame) {
    frame.getGlassPane().setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.WAIT_CURSOR));
    frame.getGlassPane().addMouseListener(mouseAdapter);
    frame.getGlassPane().setVisible(true);
}

private static void stopWaitCursor(javax.swing.JFrame frame) {
    frame.getGlassPane().setCursor(originalCursor);
    frame.getGlassPane().removeMouseListener(mouseAdapter);
    frame.getGlassPane().setVisible(false);
}

private static java.awt.Cursor originalCursor = null;

private static final java.awt.event.MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
};

public static final int DELAY_MS = 250;