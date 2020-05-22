public abstract control implements ActionListener{
    public static void btclicked(ActionEvent e, GUI gui){
        String txf = gui.getTx();
        JOptionPane.showMessageDialog(null, txf);
    }
}