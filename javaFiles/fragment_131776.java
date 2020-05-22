public class MainGui {

    private JFrame top;

    public MainGui(ActionListener listener) {
        top = new JFrame();
        top.setBounds(300, 300, 600, 300);
        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(listener);
        top.add(doneButton);
        top.pack();
        top.setVisible(true);
    }
}