import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Test1{

    //Should components be final? Should they be defined outside of the class?
    private final JTextArea outputArea = new JTextArea();
    private final JTextField errorReportField = new JTextField();

    private final JPanel inputPanel = new JPanel();

    private final JLabel nameLabel = new JLabel("Item Name");
    private final JLabel numberLabel = new JLabel("Number of units (or Volume in L)");
    private final JLabel priceLabel = new JLabel("Price per unit (or L) in pence");

    private final JTextField nameField = new JTextField(10);
    private final JTextField numberField = new JTextField(10);
    private final JTextField priceField = new JTextField(10);

    private final JButton addVolumeButton = new JButton("Add by Volume");
    private final JButton addNumberButton = new JButton("Add by number of units");         

    public Test1() {
        JFrame frame = new JFrame("Fuel station shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //outputArea.setEditable(false);
        outputArea.setRows(30);
        JScrollPane scrollPanel = new JScrollPane(outputArea);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //errorReportField.setEditable(false);

        //Better way of adding multiple components to panel?
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(numberLabel);
        inputPanel.add(numberField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(addVolumeButton);
        inputPanel.add(addNumberButton);

        Container contentPane = frame.getContentPane();
        //Why is it adding components from bottom to top?
        contentPane.setLayout(new BorderLayout());
        contentPane.add(scrollPanel);
        JPanel wrapper = new JPanel(new GridLayout(0, 1));
        wrapper.add(errorReportField);
        wrapper.add(inputPanel);
        contentPane.add(wrapper, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                Test1 test = new Test1();
            }
        });  
    }
}