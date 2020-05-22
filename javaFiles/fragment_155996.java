BorderLayout borderlayout = new BorderLayout();      

    //Creates the frame, set the visibility to true, sets the size and exit on close
    JFrame frame = new JFrame("Games");
    frame.setVisible(true);
    frame.setSize(600,400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    //Creates the Throw Dice button
    Panel p = new Panel();
    p.setLayout(new GridLayout());

    final Dice dice = new Dice();
    Button button = new Button("Throw Dice");
    final Label label = new Label("Dice Draw");

    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            dice.randomGenerator();
            label.setText(Integer.toString(dice.getDiceResult()));
        }
    });

    p.add(button);
    p.add(label); //This is where I want the dice result to be shown when hit the button
    p.setBackground(new Color(156, 93, 82));
    frame.add(p, BorderLayout.SOUTH);