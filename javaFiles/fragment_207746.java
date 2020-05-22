import java.awt.FlowLayout;
import javax.swing.*;
/*
 * This code is bad dealing with Swing component update
 * 
 * Update a Swing component from A Non-EDT thread is not encouraged
 * may  incur error like:
 * 
 * Exception in thread "AWT-EventQueue-0" java.lang.NullPointerException
 */
public class ListExampleBad {
    public static void main(String[] args) {
       final ListFrame listFrame=new ListFrame();
        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //use a thread to update list data
                new Thread(new UpdateList(listFrame)).start();
                System.out.println("Asim");
            }
        });
    }
}
//list fram with JList
class ListFrame extends  JFrame{
    public ListFrame(){
        jp.add(sp);
        super.add(jp);
        super.setVisible(true);
        super.setLayout(new FlowLayout());
        super.setSize(400,500);
    }
    public synchronized void updateList(String[] n){
         list.setListData(n);
         list.updateUI();
    }
    private static final long serialVersionUID = 1L;
    private DefaultListModel<String> DLM=new DefaultListModel<String>();
    private JList<String> list=new JList<String>(DLM);
    private JPanel jp=new JPanel();
    private JScrollPane sp=new JScrollPane(list);
}
//runnable dealing with data update
class UpdateList implements Runnable {
    public UpdateList(ListFrame listFrame) {
        this.ListFrame = listFrame;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        if(SwingUtilities.isEventDispatchThread()) {
            System.out.println("updating list from Event Dispatch Thread");
        }else {
            System.out.println("updating list NOT from Event Dispatch Thread");
        }
         String[] n={"Asim", "saif","Khan"};
         ListFrame.updateList(n);
    }
    private ListFrame ListFrame;
}