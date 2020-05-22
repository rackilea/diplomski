JLayeredPane pane = new JLayeredPane();

    JLabel ontop = new JLabel("On top");
    JLabel behind = new JLabel("Behind");

    pane.add(ontop, 2, 0);
    pane.add(behind, 1, 0);