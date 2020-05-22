public class View extends JFrame {

    private Model model;
    private JButton btn;

    public View(Model model) {
        this.model = model;
        this.btn = new JButton("Test");
    }

    public void addViewControlListener(ActionListener al){
        btn.addActionListener(al);
    }
}