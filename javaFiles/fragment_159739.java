public WQQuery(String name) throws IOException {
    super(name);

    setLayout(new FlowLayout());
    addWindowListener(this);

    InterFaceLabel = new JLabel("Interface: ");
    add(InterFaceLabel);

    InterFaceField = new JTextField(10);
    InterFaceField.addActionListener(this);
    add(InterFaceField);

    ErrorCodeLabel = new JLabel("Error Code:");
    add(ErrorCodeLabel);

    ErrorCodeField = new JTextField(10);
    ErrorCodeField.addActionListener(this);
    add(ErrorCodeField);

    button1 = new JButton("Search");
    add(button1);
    add(SQLLabel);
    button1.addActionListener(this);