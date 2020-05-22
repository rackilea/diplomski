public JButtonO() {
    super("the button");
    this.setSize(400, 200);

    // Create a panel with a borderlayout
    JPanel jpanel = new JPanel(new BorderLayout());

    JLabel label = new JLabel("Output Items:");
    label.setAlignmentX(1);
    label.setAlignmentY(1);
    // Add Label to top of layout
    jpanel.add(label, BorderLayout.NORTH);

    JList conList = new JList(values);
    conList.setVisibleRowCount(3);
    JScrollPane scroller = new JScrollPane(conList);
    //AddScroll to center
    jpanel.add(scroller);

    //Add Panel to JFrame
    this.add(jpanel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

  }