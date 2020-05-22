public class MySystemGUI implements ActionListener {
    ...
    public MySystemGUI() {
       ...
       myFrame.setLayout(new GridBagLayout());
       myFrame.setSize(700, 500);
       myFrame.setTitle("My System GUI");
       myFrame.setVisible(true);
       ...
    }
}