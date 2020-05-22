trayIcon.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            alertPulse.runAlert();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
});