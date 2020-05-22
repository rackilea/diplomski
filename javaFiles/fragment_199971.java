import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class melco extends JFrame{

  String str;
  int x = 100, y = 100;

  public melco(String title){
    super(title);
  }

  void print(String s){
    str = s;
    repaint();
  }

  public void paint(Graphics g){
    super.paint(g);
    if (str != null)
      g.drawString(str, x, y);
  }
  public static void main(String[] args){
    final melco frame = new melco("Salesman Resources");
    frame.setVisible(true);
    frame.setSize(1000,800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar menubar = new JMenuBar();
    frame.setJMenuBar(menubar);

    JMenu file = new JMenu("File");
    menubar.add(file);
    JMenuItem exit = new JMenuItem("Exit");
    file.add(exit);

    JMenu orders = new JMenu("Orders");
    menubar.add(orders);
    JMenuItem bookedorders = new JMenuItem("Booked Orders");
    orders.add(bookedorders);
    JMenuItem backorders = new JMenuItem("BackOrders");
    orders.add(backorders);

    JMenu customers = new JMenu("Customers");
    menubar.add(customers);
    JMenuItem customersales = new JMenuItem("Customer Sales");
    customers.add(customersales);
    JMenuItem customeritems = new JMenuItem("Customer Items");
    customers.add(customeritems);
    JMenuItem customerprices = new JMenuItem("Customer Prices");
    customers.add(customerprices);
    JMenuItem customerlistings = new JMenuItem("Customer Listings");
    customers.add(customerlistings);

    JMenu inv = new JMenu("INV");
    menubar.add(inv);
    JMenuItem surplusinv = new JMenuItem("Surplus Inv");
    inv.add(surplusinv);
    JMenuItem stockinv = new JMenuItem("Stock Inv");
    inv.add(stockinv);

    JMenu search = new JMenu("Searh");
    menubar.add(search);
    JMenuItem itemsearch = new JMenuItem("Item Search");
    search.add(itemsearch);
    JMenuItem customersearch = new JMenuItem("Customer Search");
    search.add(customersearch);

    JMenu menulostsales = new JMenu("Lost Sales");
    menubar.add(menulostsales);
    JMenuItem lostsales = new JMenuItem("Lost Sales");
    menulostsales.add(lostsales);


    JMenu menumarginadvisor = new JMenu("Margin Advisor");
    menubar.add(menumarginadvisor);
    JMenuItem marginadvisor = new JMenuItem("Margin Advisor");
    menumarginadvisor.add(marginadvisor);


    JMenu menumakeandhold = new JMenu("Make and Hold");
    menubar.add(menumakeandhold);
    JMenuItem makeandhold = new JMenuItem("Make and Hold");

    menumakeandhold.add(makeandhold);

    makeandhold.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
          System.out.println("Make and Hold is pressed");
          frame.print("Make and Hold is pressed");
          System.out.println("Hello World");
          frame.print("Hello World");
// This is Make and Hold Area

        }
      }
    );

    class exitaction implements ActionListener {
      public void actionPerformed (ActionEvent e){
        System.exit(0);
      }
    }
    exit.addActionListener(new exitaction());


  }

}