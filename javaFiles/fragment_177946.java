public class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println("clicked column " + btn.getClientProperty("column")
                + ", row " + btn.getClientProperty("row"));
}