TimeKeeper timeKeeper = new TimeKeeper();
ControlsPane controlsPane = new ControlsPane();
controlsPane.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ControlsPane.START_COMMAND:
                timeKeeper.start();
                break;
            case ControlsPane.STOP_COMMAND:
                timeKeeper.stop();
                break;
        }
    }
});

JFrame frame = new JFrame("Testing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(timeKeeper);
frame.add(controlsPane, BorderLayout.SOUTH);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);