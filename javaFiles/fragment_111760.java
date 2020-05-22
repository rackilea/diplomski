import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

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

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
                    Date startDate = sdf.parse("3.1.2013");
                    Date endDate = sdf.parse("3.1.2016");

                    JTable table = new JTable(new CalendarModel(startDate, endDate));

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new JScrollPane(table));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (ParseException | HeadlessException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public static class CalendarModel extends AbstractTableModel {

        public static String[] COLUMN_NAMES = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        private int rows = 0;

        private Date startOfWeek;
        private Date startDate;
        private Date endDate;

        public CalendarModel(Date startDate, Date endDate) {

            this.startDate = startDate;
            this.endDate = endDate;

            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            while (cal.getTime().before(endDate)) {
                cal.add(Calendar.DATE, 7);
                rows++;
            }
            rows++;

            if (rows > 0) {

                int offset = 0;
                cal.setTime(startDate);
                while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {

                    cal.add(Calendar.DATE, -1);
                    offset++;

                }

                startOfWeek = cal.getTime();
                System.out.println("Start @ " + cal.getTime());
                System.out.println("rows = " + rows);

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

                Calendar cal = Calendar.getInstance();
                cal.setTime(startOfWeek);
                int day = (rowIndex * 7) + columnIndex;
                System.out.println("day = " + day);
                cal.add(Calendar.DATE, day);

                if (cal.getTime().before(startDate) || cal.getTime().after(endDate)) {

                    date = null;

                } else {

                    date = cal.getTime();
                    System.out.println("Real date = " + date);

                }

            }

            return date;

        }

    }

}