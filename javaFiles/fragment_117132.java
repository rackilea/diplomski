import java.awt.*;
import javax.swing.*;

public class Statistics {

    private JFrame frame;
    private JPanel contentPane;
    private String[] columnNames = {"Statistic name", "Statistic value"};
    private Object[][] data = {{"Score", "0"}, {"Correct percentage", "100%"}};
    private JTable table = new JTable(data, columnNames);
    private JScrollPane scrollPane = new JScrollPane(table);

    public Statistics() {
        frame = new JFrame("Statistics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(getComponents());
        frame.setLocation(150, 150);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel getComponents() {
        contentPane = new JPanel(new BorderLayout(10, 10));        
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        return contentPane;
    }

    public static void main(String[] arguments) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Statistics statistics = new Statistics();
            }
        });
    }
}