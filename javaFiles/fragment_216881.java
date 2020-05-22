EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        NewJFrameSplash frame = new NewJFrameSplash();
        frame.setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                // Create next window
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
});