/** @see http://stackoverflow.com/q/9540263/230513 */
public class Test {

    private static Test test = new Test();
    private JPanel myPanel;
    private JList myList;
    private JLabel myLabel;

    public Test() {
        myPanel = new JPanel();
        myPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        String[] values = {"Value1", "Value2", "Value3", "Value4"};
        myList = new JList(values);
        myPanel.add(this.myList, gbc);
        myLabel = new JLabel("Label1");
        myPanel.add(this.myLabel, gbc);
        myPanel.add(new JButton(new AbstractAction("Select Value3") {

            @Override
            public void actionPerformed(ActionEvent e) {
                test.updateList(2);
            }
        }));
    }

    public void updateLabel(String label) {
        myLabel.setText(label);
    }

    public void updateList(int index) {
        myList.setSelectedIndex(index);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(test.myPanel);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        });
    }
}