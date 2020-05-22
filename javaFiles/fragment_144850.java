public class OtherClass .. {
    private JLabel jLabel1;

    public JLabel getLabel() {
        return jLabel1;
    }
}

import otherpackage.OtherClass;

public class MainFrame extends JFrame {
    private OtherClass otherClass;
    ...
    private void jButtonActionPerformed(ActionEvent e) {
         JLabel label = otherClass.getLabel();
         label.setBackground(...)
    }
}