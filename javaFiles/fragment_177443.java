public GUIBase() {
    super("Minesweeper");
    setLayout(new FlowLayout());

    this.buttons = new JButton[MAX_BUTTONS];


    //Fields
    int position;
    for (int i = 0; i < buttons.length; i++) {
        position = (int) (Math.random() * 100);

        this.buttons[ i ] = new JButton("R");
        this.buttons[ i ].setToolTipText("Is this the correct one?");
        this.add(this.buttons[ i ]);

        Action action = new Action();
        this.buttons[ i ].addActionListener(action);
    }
}