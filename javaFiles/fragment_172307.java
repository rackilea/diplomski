import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Timer {

    static class CustomRenderer extends DefaultTableCellRenderer {

        @SuppressWarnings("compatibility:-3065188367147843914")
        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            Component cellComponent
                    = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String time = (String) table.getValueAt(row, column);
            if (time!=null && time.compareTo("00:05:00") <= 0) {
                cellComponent.setBackground(Color.RED);
            } else {
                cellComponent.setBackground(Color.WHITE);
            }
            return cellComponent;
        }
    }

    class PassTime extends Thread {

        private int initialSeconds;
        private final int row;
        private final int column;

        public PassTime(int row, int column, int initialSeconds) {
            this.initialSeconds = initialSeconds;
            this.row = row;
            this.column = column;
        }

        @Override
        @SuppressWarnings("SleepWhileInLoop")
        public void run() {
            while (initialSeconds >= 0) { //while we can countdown
                try {
                    //set the new value in the row/column position in the matrix
                    ((DefaultTableModel) table.getModel()).setValueAt(getTime(initialSeconds), row, column);
                    //let the table know it's data has been modified
                    ((DefaultTableModel) table.getModel()).fireTableDataChanged();
                    Thread.sleep(1000); //wait 1 second
                    initialSeconds--; //decrement seconds by 1
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void PassTheTime(int row, int column, int time) {
        PassTime timer = new PassTime(row, column, time);
        timer.start();
    }

    static Object[] columnNames = new Object[]{"Time 1", "Time 2"}; //table header
    static String[][] rowData = new String[2][2]; //only a 2 by 2 matrix in this example
    private final JPanel mainPanel = new JPanel();
    private final DefaultTableModel tableModel;
    private final JTable table;

    //method to get time from seconds as hh:mm:ss
    public static String getTime(int totalSecs) {
        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;
        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return timeString;
    }

    public Timer() {
        tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);
        int columnCount = table.getColumnModel().getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new CustomRenderer());
        }
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private static void createAndShowGui() {
        final Timer timer = new Timer();

        JFrame frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(timer.getMainPanel());
        frame.pack();
        frame.setSize(200, 200);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                //start each timer
                //pass row,column position in the matrix for each Time and the seconds value
                timer.PassTheTime(0, 0, 302);
                timer.PassTheTime(0, 1, 320);
                timer.PassTheTime(1, 0, 310);
                timer.PassTheTime(1, 1, 420);

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGui();
            }
        });
    }
}