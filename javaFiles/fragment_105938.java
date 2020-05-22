public Test(){
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(true);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    //Add buttons to panels
    pane.add(startTimer);
    pane.add(time);
    exitPane.add(exitButton);

    //Add panels to form;
    add(pane, BorderLayout.NORTH);
    add(exitPane, BorderLayout.SOUTH);

    //Add ActionListeners to Buttons
    startTimer.addActionListener(this);
    exitButton.addActionListener(this);
    // LOOK! THIS LINE!
    // VVVVVVVVVVVVVVV
    timer.addActionListener(this);
}