import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class JDialogDemo extends JFrame {

    public JDialogDemo() {

        final MyDialog dialog = new MyDialog(this);

        final JTextField provinceField = new JTextField(10);

        JButton button = new JButton("Show Dialog");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.pack();
                dialog.setLocationRelativeTo(JDialogDemo.this);

                dialog.setVisible(true);

                provinceField.setText(dialog.getSelectedProvince());
            }
        });

        setLayout(new FlowLayout());
        add(provinceField);
        add(button);

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JDialogDemo();
    }
}

class MyDialog extends JDialog {

    private String selectedProvince;

    public MyDialog(Frame owner) {
        super(owner, true);

        setTitle("Provinces");

        final JList<String> list = new JList<String>(new String[]{"province1", "province2", "province3"});
        add(list);

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedProvince = list.getSelectedValue();
                setVisible(false);
            }
        });

        add(okButton, BorderLayout.SOUTH);
    }

    public String getSelectedProvince() {
        return selectedProvince;
    }

}