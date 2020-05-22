class bmicalc extends JFrame{

public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            bmicalc GUI = new bmicalc();
            GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GUI.setVisible(true);
        }
    });
}

public bmicalc() {
    initComponents();

}

private void initComponents() {
    //............
}
}