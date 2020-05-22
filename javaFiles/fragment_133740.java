public Frame()
  {
    //create label and add it to the frame
    JLabel label = new JLabel("Tic Tac Toe");
    label.setHorizontalAlignment( JLabel.CENTER );
    add(label, BorderLayout.NORTH);

    //create buttonsPanel and add it to the frame 
    JPanel buttons = new JPanel();
    buttons.setLayout( new GridLayout(3, 3));
    for (int i = 0; i < 9; i++)
    {
      buttons.add(new JButton(""+i));
    }
    add(buttons, BorderLayout.CENTER);

    //setup the title, other properties for the frame etc.. 
    setTitle("Tic Tac Toe");
    setSize(1000, 1000);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }