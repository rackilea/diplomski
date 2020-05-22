import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import java.util.Timer;

public class DateTimeTable
{
  public static void main(String[] args)
  {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTable table = new JTable(
        new String[][] {
            {"Water plants", "2019.01.12", "09:21"},
            {"Read Java book", "2019.01.12", "19:30"},
            {"Go to bed", "2019.01.12", "22:30"}},
        new String[] {"Name", "Date", "Time"});

    TimerTask task = new TimerTask()
    {
      @Override
      public void run()
      {
        String date = table.getValueAt(0, 1).toString();
        String time = table.getValueAt(0, 2).toString();
        LocalDateTime alertTime = LocalDateTime.parse(date + " " + time,
            DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

        if (alertTime.isBefore(LocalDateTime.now()))
        {
          JOptionPane.showMessageDialog(f, table.getValueAt(0, 0));
        }
        else
        {
          System.out.println("No alerts");
        }
      }
    };

    Timer timer = new Timer();
    timer.schedule(task, 1000, 5 * 60 * 1000);

    f.getContentPane().add(new JScrollPane(table));
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}