public buttonPanel() {
    super(new GridLayout(1,3));
    bg = new ButtonGroup();
    enterItemButton = new JButton("Enter Item");
    totalButton = new JButton("Total");
    newOrderButton = new JButton("New Order");

    this.setSize(150, 780);
    this.add(enterItemButton);
    bg.add(enterItemButton);
    this.add(totalButton);
    bg.add(totalButton);
    this.add(newOrderButton);
    bg.add(newOrderButton);
    this.setVisible(true);

    }
}