public class MyView extends JFrame {

    public MyView() {
       JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(800, 600);
        JTextArea enterName1 = new JTextArea(50, 50);
        enterName1.setRows(20);
        enterName1.setColumns(1);
        panel.add(enterName1, BorderLayout.CENTER);
        enterName1.setVisible(true);
        panel.setVisible(true);
        this.add(panel);
        this.setVisible(true);
        this.setSize(800, 600);
    }
}