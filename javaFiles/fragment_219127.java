GUI() {

    super("XML Writer");

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(0, 2));

    JLabel fn = new JLabel("First Name");
    firstName = new JTextField();
    panel.add(fn);
    panel.add(firstName);

    JLabel ln = new JLabel("Last Name");
    lastName = new JTextField();
    panel.add(ln);
    panel.add(lastName);

    JLabel s = new JLabel("Salary");
    salary = new JTextField();
    panel.add(s);
    panel.add(salary);

    button1 = new JButton("Click Me!");
    button1.setSize(20, 10);
    panel.add(button1);

    Handler handler = new Handler();
    button1.addActionListener(handler);

    //...???
}