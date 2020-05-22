JInternalFrame frmUpdateData = null;
    frmUpdateData = new JInternalFrame("Test", true, true);
    frmUpdateData.setBounds(0, 0, 200, 200);
    JDesktopPane desktopPane = new JDesktopPane();
    desktopPane.setBounds(0, 0, 600, 600);
    desktopPane.add(frmUpdateData);
    desktopPane.setVisible(true);
    frmUpdateData.setVisible(true);
    JFrame frame = new JFrame();
    frame.setBounds(0, 0, 600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(desktopPane);
    frame.setVisible(true);
    while (frmUpdateData != null && !frmUpdateData.isClosed()) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    JOptionPane.showMessageDialog(null, "Done");