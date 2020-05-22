public class CustomInput {

private JButton btAccept;
private JButton btCancel;
private JLabel lbInput;
private JTextField tfInput;
private JPanel pnDialog;

private JPanel createPanel() {
    java.awt.GridBagConstraints gridBagConstraints;
    pnDialog = new JPanel();
    lbInput = new JLabel();
    tfInput = new JTextField();
    btAccept = new JButton();
    btCancel = new JButton();

    pnDialog.setLayout(new java.awt.GridBagLayout());

    btAccept.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btAcceptAction(evt);
        }
    });

    btCancel.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btCancelAction(evt);
        }
    });

    lbInput.setText("Enter your input.");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    pnDialog.add(lbInput, gridBagConstraints);

    tfInput.setText("");
    tfInput.setColumns(10);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    pnDialog.add(tfInput, gridBagConstraints);

    btAccept.setText("Accept");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    pnDialog.add(btAccept, gridBagConstraints);

    btCancel.setText("Cancel");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 2;
    pnDialog.add(btCancel, gridBagConstraints);

    return pnDialog;
    //Mommy someone is reading my code
}

private void btAcceptAction(java.awt.event.ActionEvent evt) {
    if (tfInput.getText().isEmpty()) {
        JOptionPane.showMessageDialog(pnDialog, "Input cannot be null", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void btCancelAction(java.awt.event.ActionEvent evt) {
    JDialog topFrame = (JDialog) SwingUtilities.getWindowAncestor(pnDialog);
    topFrame.dispose();
}

public static void main(String[] args) {
    JDialog dialog = new JDialog();
    CustomInput tp = new CustomInput();
    dialog.add(tp.createPanel());
    dialog.setSize(new Dimension(200,200));
    dialog.setVisible(true);
}

}