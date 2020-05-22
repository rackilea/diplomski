import java.awt.EventQueue;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class BuildCalendar {

    public static void main(String[] args) {
        new BuildCalendar();
    }

    public BuildCalendar() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DateTimeFormatter dtf = DateTimeFormat.forPattern("MM.dd.yyyy");
                DateTime startDate = dtf.parseDateTime("3.1.2013");
                DateTime endDate = dtf.parseDateTime("3.1.2016");

                JTable table = new JTable(new CalendarModel(startDate, endDate));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class CalendarModel extends AbstractTableModel {

        public static String[] COLUMN_NAMES = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        private int rows = 0;

        private MutableDateTime startOfWeek;
        private DateTime startDate;
        private DateTime endDate;

        public CalendarModel(DateTime startDate, DateTime endDate) {
            this.startDate = startDate;
            this.endDate = endDate;

            int days = Days.daysBetween(startDate, endDate).getDays();
            if (days > 0) {

                startOfWeek = new MutableDateTime(startDate);
                while (startOfWeek.getDayOfWeek() != DateTimeConstants.SUNDAY) {

                    startOfWeek.addDays(-1);

                }

                int offset = Days.daysBetween(startOfWeek, startDate).getDays();
                days += offset;

                System.out.println(NumberFormat.getNumberInstance().format(days / 7d));
                rows = (int) Math.round(days / 7d) + 1;
                System.out.println(rows);

            }
        }

        @Override
        public int getRowCount() {
            return rows;
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return Date.class;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            Date date = null;

            if (startOfWeek != null) {

                MutableDateTime dt = new MutableDateTime(startOfWeek);
                int day = (rowIndex * 7) + columnIndex;
                dt.addDays(day);

                if (dt.isBefore(startDate) || dt.isAfter(endDate)) {

                    date = null;

                } else {

                    date = dt.toDate();

                }

            }

            return date;

        }

    }

}