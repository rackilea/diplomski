public class BadLayout07 {

    public static void main(String[] args) {
        new BadLayout07();
    }

    public BadLayout07() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MasterPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MasterPane extends JPanel {

        public MasterPane() {
            EncryptSettings encryptSettings = new EncryptSettings();
            InputPane inputPane = new InputPane();
            OutputPane outputPane = new OutputPane();

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(encryptSettings, gbc);

            gbc.gridy++;
            gbc.weighty = 1;
            gbc.fill = gbc.BOTH;
            add(inputPane, gbc);

            gbc.gridy++;
            add(outputPane, gbc);
        }

    }

    public class EncryptSettings extends JPanel {

        private JRadioButton encrypt;
        private JRadioButton decrypt;
        private JSpinner factor;

        public EncryptSettings() {
            encrypt = new JRadioButton("Encrypt");
            decrypt = new JRadioButton("Decrypt");
            ButtonGroup bg = new ButtonGroup();
            bg.add(encrypt);
            bg.add(decrypt);

            factor = new JSpinner(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));

            setLayout(new FlowLayout(FlowLayout.LEFT));
            add(encrypt);
            add(decrypt);
            add(factor);
        }

    }

    public class InputPane extends JPanel {

        private JTextArea input;
        private JButton open;
        private JButton close;

        public InputPane() {
            setBorder(new TitledBorder("Source Text"));
            input = new JTextArea();
            open = new JButton("Open");
            close = new JButton("Close");

            JPanel tb = new JPanel(new FlowLayout(FlowLayout.LEFT));
            tb.add(open);
            tb.add(close);

            setLayout(new BorderLayout());
            add(tb, BorderLayout.NORTH);
            add(new JScrollPane(input));
        }

    }

    public class OutputPane extends JPanel {

        private JTextArea output;
        private JButton save;
        private JButton send;

        public OutputPane() {
            setBorder(new TitledBorder("Encrypted Text"));
            output = new JTextArea();
            output.setEditable(false);
            save = new JButton("Save");
            send = new JButton("Send");

            JPanel tb = new JPanel(new FlowLayout(FlowLayout.LEFT));
            tb.add(save);
            tb.add(send);

            setLayout(new BorderLayout());
            add(tb, BorderLayout.NORTH);
            add(new JScrollPane(output));
        }

    }

}