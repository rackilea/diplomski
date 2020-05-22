public Gui(){
    setTitle("Basic Gui");
    setResizable(false);
    setSize(500, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);    

    Container pane = getContentPane();
    pane.setLayout(null);


    button = new JButton("button");
    button.setBounds(50, 60, 50, 70);
    bHandler = new buttonHandler();
    button.addActionListener(bHandler);

    label = new JLabel("Hello", SwingConstants.RIGHT);
    label.setBounds(50, 60, 50, 70);

    textField = new JTextField(10);
    textField.setBounds(50, 60, 50, 70);

    pane.add(button);
    pane.add(label);
    pane.add(textField);
    setVisible(true); // Move it to here
}