public class Test {
    private JFrame myFrame;
    public Test() {
        myFrame = new JFrame();
        myFrame.setVisible(true);
        myFrame.setSize(300, 300);
        myFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                PutTray();
            }
        });
    }
    private void PutTray() {
        myFrame.setVisible(false); //replace with dispose(); and it's ok
        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                myFrame.setVisible(true);
            }
        });
        t.setRepeats(false);
        t.start();
    }
    public static void main(String[] args) {
        new Test();
    }
}