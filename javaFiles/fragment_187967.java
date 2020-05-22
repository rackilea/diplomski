public Admin_hs(){
    this.setTitle("Welcome Admin!");
    this.setLayout(new GridBagLayout());

        ///Setting a layout
    pnl1.setLayout(new GridBagLayout());   // ADD THIS LINE
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridwidth= GridBagConstraints.REMAINDER;
    gbc.fill= GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1;                       // ADD THIS LINE so it uses all the existing window size in x direction
    pnl1.add(pnl);                         // ADD THIS LINE
    [...]
    // CHANGE THIS LINE to use the bottom border of your pnl1
    pnl1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
    this.add(pnl1,gbc);                    // CHANGE THIS LINE to add pnl1 and not pnl to your main window
}