import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;
import java.awt.BorderLayout;


public class Learningfromscrach extends JFrame 
{
    Toolkit toolkit;
    Timer timer = new Timer();
    DefaultTableModel model;
    JTable table;
    String url = "http://bmreports.com/bsp/additional/soapfunctions.php?element=SYSPRICE&dT=NRT";
    String col[] = {"SBP","SSP","Period"};
    JScrollPane scrollPane;

    public Learningfromscrach() 
    //tell java to initiate the create interface
    //this is what is passed to the timer every 10 seconds
    {
        createUserInterface();
    }

private void createUserInterface()
//all the parts to create the userinterface      
{//from here
    setLayout( new BorderLayout());
    setTitle("Cashout Prices");//setTitle is also a JAVA Parameter
    setVisible(true);    //makes the java application show


    table = CreateTable(url,col);

    scrollPane = new JScrollPane(table,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    add(scrollPane,BorderLayout.CENTER);
    pack();
    setSize(getWidth(), 200); //initial size

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    int delay = 5000; //5 seconds
    int period = 5000; //5 seconds

    timer.scheduleAtFixedRate(new TimerTask() 
    {
        public void run() {
            RefreshTable(url, col);
            System.out.format("Task run..");
        }
    }, delay, period);
}     
private Object[][] GetTableInfo(String url)
{
      Document doc = null;
      try 
      {
            doc = Jsoup.connect(url).get();
      } 
      catch (IOException ex) 
      {
            Logger.getLogger(Learningfromscrach.class.getName()).log(Level.SEVERE, null, ex);
      }
      Elements Periodparagraphs;      
      Elements SSPparagraphs;
      Elements SBPparagraphs; 

      Periodparagraphs = doc.select("SP");//counts the number of SSP Paragraphs in the entire document
      SSPparagraphs = doc.select("SSP");//counts the number of SSP Paragraphs in the entire document
      SBPparagraphs = doc.select("SBP");//counts the number of SBP Paragraphs in the entire document

      String[] numbers1;
      numbers1 = Periodparagraphs.text().split(" ");

      String[] numbers;
      numbers = SSPparagraphs.text().split(" ");

      String[] numbers0;
      numbers0 = SBPparagraphs.text().split(" ");

      int tableRows;

      if (numbers0.length > numbers.length && numbers0.length > numbers1.length)
      {
          tableRows = numbers0.length;
      }
      else if (numbers.length > numbers0.length && numbers.length > numbers1.length)
      {
          tableRows = numbers.length;
      }
      else
      {
          tableRows = numbers1.length;
      }

      Object[][] data = new String[tableRows][3];//3 is number of columns

      for (int x = 0; x < tableRows; x++ )
      {
          try
          {
              data[x][0] = numbers1[x];
          }
          catch (IndexOutOfBoundsException e)
          {
              data[x][0] = "  ";//error
          }

          try
          {
              data[x][1] = numbers[x];
          }
          catch (IndexOutOfBoundsException e)
          {
              data[x][1] = "  ";
          }

          try
          {
              data[x][2] = numbers0[x];
          }
          catch (IndexOutOfBoundsException e)
          {
              data[x][2] = "  ";
          }
      }

    return data;
}

private JTable CreateTable(String url, String[] cols)
{
    JTable tempTable=new JTable(GetTableInfo(url),col)
    {
        @Override
        public boolean isCellEditable(int arg0, int arg1) 
        {
            return false;
        }   
    };

    JTableHeader header = tempTable.getTableHeader();
    header.setBackground(Color.yellow);

    tempTable.setLayout(null);
    tempTable.setVisible(true);

    return tempTable;
}

private void RefreshTable(String url, String[] cols)
{
    Object[][] info = GetTableInfo(url);
    for (int row = 0; row < info.length; row++)
    {
        for (int column = 0; column < cols.length; column++)
        {
            table.setValueAt(info[row][column],row, column);
        }
    }
}

public static void main(String[] args) throws InterruptedException 
{
    // TODO code application logic here
    // BasicConfigurator.configure();
    new Learningfromscrach();

    System.out.format("Task scheduled.. Now wait for 5 sec to see next message..%n");
}