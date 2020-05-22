public class CalculatorForm {

    private static final long serialVersionUID = 1L;

    public CalculatorForm() {
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame();
        // frame settings like size, close operation etc.
        JPanel panel = new JPanel();
        // init textfields and buttons
        // add listeners or whatever
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        // layout settings goes here
        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorForm();
            }
        });
    }
}