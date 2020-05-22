import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class TestFormattedField extends JPanel {
    private JFormattedTextField txtPesquisar = new JFormattedTextField();
    private JRadioButton rbNome = new JRadioButton("None");
    private JRadioButton rbFormat = new JRadioButton("Format");

    public TestFormattedField() {
        txtPesquisar.setColumns(20);
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rbFormat);
        btnGroup.add(rbNome);

        rbNome.setSelected(true);
        rbNome.setMnemonic(KeyEvent.VK_N);
        rbFormat.setMnemonic(KeyEvent.VK_F);
        add(txtPesquisar);
        add(rbFormat);
        add(rbNome);
        setMask();

        add(new JButton(new SetFormatAction()));
        add(new JButton(new GetTextAction()));
    }

    private void setMask() {
        MaskFormatter formatter = null;
        try {
            txtPesquisar.setValue(null);
            if (rbNome.isSelected()) {
                //clear mask to type normally
                formatter = new MaskFormatter("****************************************");
                formatter.setPlaceholderCharacter(' ');
            } else {
                //set mask
                formatter = new MaskFormatter("###.###.###-##");
                formatter.setPlaceholderCharacter(' ');
            }
            txtPesquisar.setFormatterFactory(new DefaultFormatterFactory(formatter));
            txtPesquisar.requestFocus();
            txtPesquisar.selectAll();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private class SetFormatAction extends AbstractAction {
        public SetFormatAction() {
            super("Set Format");
            putValue(MNEMONIC_KEY, KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setMask();
        }
    }

    private class GetTextAction extends AbstractAction {
        public GetTextAction() {
            super("Get Text");
            putValue(MNEMONIC_KEY, KeyEvent.VK_G);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            final String text = txtPesquisar.getText();
            try {
                txtPesquisar.commitEdit();
            } catch (ParseException e1) {
                String title = "Incomplete Text Entry";
                String msg = "Text -- " + text + " is not yet complete";
                JOptionPane.showMessageDialog(TestFormattedField.this, msg, title, JOptionPane.ERROR_MESSAGE);
            }  
            Object value = txtPesquisar.getValue();

            System.out.println("text: " + text);
            System.out.println("value: " + value);
        }
    }

    private static void createAndShowGui() {
        TestFormattedField mainPanel = new TestFormattedField();

        JFrame frame = new JFrame("Test JFormattedField");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}