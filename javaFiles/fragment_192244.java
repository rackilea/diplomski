public class MyPanel extends JPanel {
    private MainWindow window;

    public MyPanel(final MainWindow window) {
        this.window = window;
        JLabel label = new Label();
        label.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                window.setVisible(false); // or dispose
            }
        });
    } 
}