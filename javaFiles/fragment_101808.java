import java.awt.BorderLayout;
import javax.swing.*;

public class JTableCreatingDemo {
  public static void main(String args[]) {

    String runner1, runner2, runner3;
    double runTime1, runTime2, runTime3;

    //Get the names and run time of each runner 
    runner1 = JOptionPane.showInputDialog("Enter name of runner 1"); //runner1
    runTime1 = Double.parseDouble(JOptionPane.showInputDialog("Enter runtime of runner 1 in minutes")); //runTime1
    while (runTime1<0)
        {
            JOptionPane.showMessageDialog(null, "Invalid Entry");
            runtTime1 = Double.parseDouble(JOptionPane.showInputDialog("Enter runtime of runner 1 in minutes \nEntery format should be MM.SS"));
        }

    runner2 = JOptionPane.showInputDialog("Enter name of runner 2"); //runner2
    runTime2 = Double.parseDouble(JOptionPane.showInputDialog("Enter runtime of runner 2 in minutes")); //runTime2
    while (runTime2<0)
        {
            JOptionPane.showMessageDialog(null, "Invalid Entry");
            runtTime2 = Double.parseDouble(JOptionPane.showInputDialog("Enter runtime of runner 2 in minutes \nEntery format should be MM.SS"));
        }

    runner3 = JOptionPane.showInputDialog("Enter name of runner 3"); //runner3
    runtime3 = Double.parseDouble(JOptionPane.showInputDialog("Enter runtime of runner 3 in minutes")); //runTime3
    while (runTime3<0)
        {
            JOptionPane.showMessageDialog(null, "Invalid Entry");
            runtTime3 = Double.parseDouble(JOptionPane.showInputDialog("Enter runtime of runner 3 in minutes \nEntery format should be MM.SS"));
        }

    //Sort the runners by their respective run times
    if(runtime1<=runtime2 && runtime1<=runtime3) //runner1 is the fastest
    {
        if(runtime2<=runtime3) 
           {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Object rowData[][] = { { runner1, runtime1 + " minutes", "-" },
                { runner2, runtime2 + " minutes", (runtime2-runtime1) },
                {runner3, runtime3 + " minutes", (runtime3-runTime1)} };
            Object columnNames[] = { "Runners Name", "Finish Time", "Differnce"
           }
 };
            JTable table = new JTable(rowData, columnNames);

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(300, 150);
            frame.setVisible(true);
    }

    }
    }