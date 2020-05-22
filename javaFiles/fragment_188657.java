public class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        int num = Integer.parseInt(btn.getText());
        result=(result*10)+num;
        lResult.setText("Result: "+result);
    }
}