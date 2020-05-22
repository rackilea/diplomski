JFrame frmMain = new JFrame(); // Create our JFrame
    // Set the layout for main frame. This controls how things get arranged on the screen
    frmMain.setLayout(new BorderLayout());

    // panels are what you put everything else on
    JPanel panel1 = new JPanel(new FlowLayout()); // another layout
    JPanel panel2 = new JPanel();
    BoxLayout box = new BoxLayout(panel2, BoxLayout.PAGE_AXIS); // another layout
    panel2.setLayout(box);

    // here are a couple of buttons
    JButton btnAdd = new JButton("Add");
    JButton btnRemove = new JButton("Remove");

    // here are a couple of textboxes. They accept typed in information
    JTextField txtFirstName = new JTextField();
    JTextField txtMiddleInitial = new JTextField();
    JTextField txtLastName = new JTextField();

    // add our buttons to panel1. It has a FlowLayout, so they will be centered left to right as we add them
    panel1.add(btnAdd); 
    panel1.add(btnRemove);

    // Create a panel to hold First Name
    JPanel pnlFirstName = new JPanel(new BorderLayout()); // also set its layout
    // here we add a JLabel.class they just display text, they don't allow input 
    pnlFirstName.add(new JLabel("first name"), BorderLayout.WEST);
    // here we put our text box onto the First name panel
    pnlFirstName.add(txtFirstName, BorderLayout.CENTER);

    // repeat for middle initial panel
    JPanel pnlMiddleInitial = new JPanel(new BorderLayout());
    pnlMiddleInitial.add(new JLabel("M.I."), BorderLayout.WEST);
    pnlMiddleInitial.add(txtMiddleInitial, BorderLayout.CENTER);

    // repeat for last name panel
    JPanel pnlLastName = new JPanel(new BorderLayout());
    pnlLastName.add(new JLabel("last name"), BorderLayout.WEST);
    pnlLastName.add(txtLastName, BorderLayout.CENTER);

    // put a 3 pixel border arounnd panel 2 to keep things away from the edge
    panel2.setBorder(new EmptyBorder(3, 3, 3, 3));
    // add all of our input panels to panel 2, according to BoxLayout (up above)
    panel2.add(pnlFirstName);
    panel2.add(pnlMiddleInitial);
    panel2.add(pnlLastName);

    // add panel1 and panel2 to the Frame. You have to add to the .getContentPane(), or you might mess things up.
    frmMain.getContentPane().add(panel1, BorderLayout.NORTH);
    frmMain.getContentPane().add(panel2, BorderLayout.CENTER);

    // This is how we tell the program what to do when the user presses the "Add" button.
    btnAdd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtFirstName.setText("My First Name");
        }
    }); 
    // This is how we tell the program what to do when the user presses the "Remove" button.
    btnRemove.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            txtFirstName.setText("");
        }
    });

    // pack just makes everything take up it's proper space on the screen in as tight of a package as possible
    frmMain.pack();
    // if you don't set visible to true, you won't see your Frame
    frmMain.setVisible(true);
    // what to do when the user clicks the "X" to close or used "Close" from the context menu
    frmMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);