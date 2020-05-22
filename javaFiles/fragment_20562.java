import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class SwapPanel2 extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int COLUMNS = 20;
    public static final String LABEL = "label";
    public static final String TEXT_FIELD = "text field";
    private JLabel label = new JLabel();
    private JTextField textField = new JTextField(COLUMNS);
    private CardLayout cardLayout = new CardLayout();

    public SwapPanel2() {
        setLayout(cardLayout);
        add(label, LABEL);
        add(textField, TEXT_FIELD);

        MyMouse myMouse = new MyMouse();

        label.addMouseListener(myMouse);
        textField.addMouseListener(myMouse);
        textField.addActionListener(myMouse);
    }

    public void showLabel() {
        label.setText(textField.getText());
        cardLayout.show(SwapPanel2.this, LABEL);
    }

    public void showTextField() {
        textField.selectAll();
        cardLayout.show(SwapPanel2.this, TEXT_FIELD);
        textField.requestFocusInWindow();
    }

    private class MyMouse extends MouseAdapter implements ActionListener {
        @Override
        public void mouseEntered(MouseEvent e) {
            showTextField();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            showLabel();
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            showLabel();
        }
    }
}