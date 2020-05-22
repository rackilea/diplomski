import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                String[][] bookings = new String[7][6];
                bookings[0][2] = "5";
                bookings[0][3] = "4";
                bookings[1][2] = "10";
                bookings[1][3] = "4";
                bookings[2][2] = "15";
                bookings[2][3] = "4";
                bookings[3][2] = "20";
                bookings[3][3] = "4";
                bookings[4][2] = "25";
                bookings[4][3] = "4";
                bookings[5][2] = "30";
                bookings[5][3] = "4";
                bookings[6][2] = "5";
                bookings[6][3] = "5";

                TableModel model = new CalendarModel(2017, Month.APRIL);
                JTable table = new JTable(model);
                table.setDefaultRenderer(LocalDate.class, new LocalDateTableCellRenderer(bookings));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}