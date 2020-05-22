public class MainFrame implements MouseListener, FocusListener {

    JTextField nameField;
    JTextField emailField

    public static void main(String[] args) {

    }


@Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getClickCount() == 1) {
           nameField.setBackground(Color.GRAY);
           emailField.setBackground(Color.GRAY);
        }

    }

     public void focusGained(FocusEvent e) {

        JTextField field = (JTextField) e.getSource();
        field.setBackground(Color.GRAY);
    }

    public void focusLost(FocusEvent e) {
        JTextField field = (JTextField) e.getSource();
        field.setBackground(Color.WHITE);
    }
}