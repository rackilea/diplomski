JFrame frame;
JButton sendMessage;
JTextField messageBox;
JTextArea chatBox;
JTextArea usernameChooser;
JFrame preFrame;

private void preDisplay() {
    // All the above fields have been redeclared here and are local to the constrcutor
    JFrame preFrame = new JFrame("Choose your username!(Colt chat v 0.1");
    JTextField usernameChooser = new JTextField();
    JLabel chooseUsernameLabel = new JLabel("Pick a username:");
    JButton enterServer = new JButton("Enter Chat Server");
    JPanel prePanel = new JPanel(new GridBagLayout());
    GridBagConstraints preRight = new GridBagConstraints();
    preRight.anchor = GridBagConstraints.EAST;
    GridBagConstraints preLeft = new GridBagConstraints();