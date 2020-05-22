public class GetUrlPanel extends JPanel {
    private static final String PROMPT = "Welcome Please Enter URL to Begin!";
    private JTextField urlField = new JTextField(10);
    private JButton goToUrlButton = new JButton("Go To URL");

    public GetUrlPanel() {
        add(new JLabel(PROMPT));
        add(urlField);
        add(goToUrlButton);
    }

    public String getUrlFieldText() {
        return urlField.getText();
    }

    public void addGoToUrlListener(ActionListener listener) {
        goToUrlButton.addActionListener(listener);
    }
}