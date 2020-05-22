public static final Color WHITE = Color.WHITE;
public static final Color RED = Color.RED;
public static final Color LIGHTER_RED = new Color(255, 0, 0, 100);
public static final Color LIGHT_RED = new Color(255, 0, 0, 160);
public static final Color DARK_BLUE = new Color(22, 44, 66);

public static final Font GEORGIA_BOLD_12 = new Font("Georgia", Font.BOLD, 12);

public static final BasicStroke STROKE_0 = new BasicStroke(0);

public static int showInputDialog(final Container parent) {
    int portNumber = 0;

    final JLabel label = new JLabel("Enter an Open Port: ", SwingConstants.LEFT);
    label.setForeground(WHITE);

    JPanel panel = new JPanel(new GridLayout(2, 1));
    panel.setOpaque(true);
    panel.setBackground(DARK_BLUE);
    JTextField inputField = new JTextField(10);
    panel.add(label);
    panel.add(inputField);

    final JButton button = new JButton("OK") {

        private static final long serialVersionUID = -4808194362293478299L;

        @Override
        public int getWidth() {
            return 51;
        }

        @Override
        public int getHeight() {
            return 26;
        }

        @Override
        public void paintComponent(final Graphics g) {
            final Graphics2D g2d = (Graphics2D) g;
            g2d.clearRect(0, 0, getWidth(), getHeight());
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setStroke(STROKE_0);
            g2d.setColor(LIGHTER_RED);
            if (this.getModel().isRollover()) {
                g2d.setColor(LIGHT_RED);
            }
            if (this.getModel().isPressed()) {
                g2d.setColor(RED);
            }
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setColor(RED);
            g2d.drawRect(0, 0, getWidth(), getHeight());
            g2d.setColor(WHITE);
            g2d.setFont(GEORGIA_BOLD_12);
            g2d.drawString("CONFIRM", 10, 18);
        }
    };
    final JOptionPane optionPane = new JOptionPane(panel, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_OPTION, null, new JButton[]{button}, button);
    button.addActionListener(e -> {
        //GET THE INPUT OF JOPTIONPANE TEXTFIELD
        optionPane.setInputValue(inputField.getText());
        optionPane.setValue(JOptionPane.OK_OPTION);
    });

    optionPane.setOpaque(true);
    optionPane.setBackground(DARK_BLUE);
    final JDialog d = optionPane.createDialog(parent, "Open port required!");
    d.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    d.setContentPane(optionPane);
    d.pack();
    d.setLocationRelativeTo(parent);
    d.setVisible(true);
    System.out.println(optionPane.getValue());
    System.out.println(optionPane.getInputValue());
    return portNumber;
}