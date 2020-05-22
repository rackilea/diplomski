@SuppressWarnings("serial")
class MainGui extends JFrame {
    private SomeDialog someDialog;
    private JButton showSomeDialogButton = new JButton("Show Some Dialog");
    private JButton closeSomeDialogButton = new JButton("Close Some Dialog");

    public MainGui() {
        super("Main GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 200));

        someDialog = new SomeDialog(this);

        showSomeDialogButton.addActionListener(new ShowDialogListener(this));
        showSomeDialogButton.setMnemonic(KeyEvent.VK_S);

        closeSomeDialogButton.addActionListener(new CloseSomeDialogListener(this));
        closeSomeDialogButton.setMnemonic(KeyEvent.VK_C);

        setLayout(new FlowLayout());
        add(showSomeDialogButton);
        add(closeSomeDialogButton);
        pack();
        setLocationByPlatform(true);
    }

    public void displaySomeDialog() {
        someDialog.setVisible(true);
    }

    public void closeSomeDialog() {
        someDialog.setVisible(false);
    }
}