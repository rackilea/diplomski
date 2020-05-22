public class InitialPanel extends JPanel {

    private static final long serialVersionUID = -3159520372145273536L;

    public InitialPanel() {
        super();
        initComponents();
    }

    private void initComponents() {

        this.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        // All mandatory fields.
        // 1.
        JLabel hwCodeLabel = addMyLabelCell(0, "HW CODE:");
        JTextField hwCodeTextField = addMyTextFieldCell(0, "");

        // 2.
        JLabel publisherIdLabel = addMyLabelCell(1, "PUBLISHER ID:");
        JTextField publisherIdTextField = addMyTextFieldCell(1, "");

        // 3.
        JLabel journalTitleLabel = addMyLabelCell(2, "JOURNAL TITLE:");
        JTextField journalTitleTextField = addMyTextFieldCell(2, "");

        // 4.
        JLabel printISSNLabel = addMyLabelCell(3, "PRINT ISSN:");
        JTextField printISSNTextField = addMyTextFieldCell(3, "");

        // 5.
        JLabel eISSNLabel = addMyLabelCell(4, "ELECTRONIC ISSN:");
        JTextField eISSNTextField = addMyTextFieldCell(4, "");

        // 6.
        JLabel publisherNameLabel = addMyLabelCell(5, "PUBLISHER NAME:");
        JTextField publisherNameTextField = addMyTextFieldCell(5, "");

        // 7.
        JLabel publisherLOCLabel = addMyLabelCell(6, "PUBLISHER LOCATION:");
        JTextField publisherLOCTextField = addMyTextFieldCell(6, "");

        // 8.
        JLabel coverDateLabel = addMyLabelCell(7, "COVER DATE:");
        JTextField coverDateTextField = addMyTextFieldCell(7, "");

        // 9.
        JLabel volumeLabel = addMyLabelCell(8, "VOLUME:");
        JTextField volumeTextField = addMyTextFieldCell(8, "");

        // 10.
        JLabel issueLabel = addMyLabelCell(9, "ISSUE:");
        JTextField issueTextField = addMyTextFieldCell(9, "");

        // 11.
        JLabel copyrightStatementLabel = addMyLabelCell(10, "COPYRIGHT STATEMENT:");
        JTextField copyrightStatementTextField = addMyTextFieldCell(10, "");

        // 12.
        JLabel copyRightYearLabel = addMyLabelCell(11, "COPYRIGHT YEAR:");
        JTextField copyRightYearTextField = addMyTextFieldCell(11, "");
    }

    public JLabel addMyLabelCell(int pos, String labelstr) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = pos;
        JLabel label = new JLabel(labelstr);
        this.add(label, gridBagConstraints);
        return label;
    }

    public JTextField addMyTextFieldCell(int pos, String text) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.ipadx = 10;
        JTextField textField = new JTextField(text);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = pos;
        textField.setColumns(10);
        this.add(textField, gridBagConstraints);
        return textField;
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new InitialPanel());
            f.setSize(300, 300);
            f.setVisible(true);
        });
    }
}