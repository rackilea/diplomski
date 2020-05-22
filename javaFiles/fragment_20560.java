import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SwapPanel extends JPanel {
    private static final int COLUMNS = 20;
    public static final String LABEL = "label";
    public static final String TEXT_FIELD = "text field";
    private JLabel label = new JLabel();
    private JTextField textField = new JTextField(COLUMNS);
    private CardLayout cardLayout = new CardLayout();

    public SwapPanel() {
        setLayout(cardLayout);
        add(label, LABEL);
        add(textField, TEXT_FIELD);

        MyMouse myMouse = new MyMouse();

        label.addMouseListener(myMouse);
        textField.addMouseListener(myMouse);
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            cardLayout.show(SwapPanel.this, TEXT_FIELD);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            label.setText(textField.getText());
            cardLayout.show(SwapPanel.this, LABEL);
        }
    }
}