public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    switch (cmd) {
        case "human": 
            selection = Option.HUMAN;
            break;
        case "robot": 
            selection = Option.ROBOT;
            break;
    }
    setVisible(false);
}