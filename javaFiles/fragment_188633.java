public class MyGui() {

    public void createAndShowGui() {

        JPanel yourCustomPanel = new TableInterfaceBDD();

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        frame.add(yourCustomPanel );
        frame.pack(); // don't forget to pack() the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}