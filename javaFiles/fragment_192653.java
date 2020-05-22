Display disp = new Display();
    Keypad keyp = new Keypad();

    JPanel c = new JPanel();
    c.setLayout(new BorderLayout());
    c.add(disp, BorderLayout.NORTH);
    c.add(keyp, BorderLayout.SOUTH);

    this.setTitle("Alex's Calculator");
    this.getContentPane().add(c, BorderLayout.CENTER);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(400, 300);
    this.setVisible(true);