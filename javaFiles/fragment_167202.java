import javax.swing.*;

public class Example {
    public static void main(String[] args) { 
        java.awt.EventQueue.invokeLater(Example::go);
    }
    private static void go() {
        ButtonModel model = new JToggleButton.ToggleButtonModel();
        openFrame("Frame A", model);
        openFrame("Frame B", model);
    }
    private static void openFrame(String title, ButtonModel checkModel) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JCheckBox checkBox = new JCheckBox("Tick me!");
        checkBox.setModel(checkModel);
        frame.add(checkBox);
        frame.pack();
        frame.setVisible(true);
    }
}