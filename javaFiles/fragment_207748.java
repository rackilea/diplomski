import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
/**
 * This example illustrate updating JList from thread
 */
public class ListExample {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListFrame listFrame = new ListFrame();
            listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                listFrame.setLocationRelativeTo(null);
                listFrame.setVisible(true);
            }
        });
    }
}
//frame with JList
class ListFrame extends  JFrame{
    public ListFrame(){
        super("Update JList Demo");

        //initalize data field
        dataToUpdate =new String[]{"Asim", "saif","Khan"};
        DefaultListModel<String> DLM =new DefaultListModel<String>();
        DLM.addElement("wait for update...");;
        list =new JList<String>(DLM);

         //build gui
        JPanel btnPanel = new JPanel();
        JButton btnUpdate = new JButton("Update");
        btnPanel.add(btnUpdate);
        JScrollPane sp=new JScrollPane(list);
        this.add(btnPanel,BorderLayout.NORTH);
        this.add(sp,BorderLayout.CENTER);
        this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //deal with action
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                ListUpdater updater = new ListUpdater();
                updater.execute();
            }
        });
    }
    public synchronized void updateList(String[] n){
         list.setListData(n);
         list.updateUI();
    }
    //using Swingworker to update list
    private class ListUpdater extends SwingWorker<Void,String>{
        @Override
        public Void doInBackground() {
            for(String str :dataToUpdate ) {
                publish(str);
            }
            return null;
        }
        @Override
        public void process (List<String> datas) {
            for(String str : datas) {
                model.addElement(str);
            }
        }
        @Override
        public void done() {
            if(SwingUtilities.isEventDispatchThread()) {
                System.out.println("updating list from Event Dispatch Thread");
            }else {
                System.out.println("updating list NOT from Event Dispatch Thread");
            }
            list.setModel(model);
        }
        private DefaultListModel<String> model =new DefaultListModel<String>();
    }
    public String[] getDataToUpdate() {
        return dataToUpdate;
    }
    public void setDataToUpdate(String[] dataToUpdate) {
        this.dataToUpdate = dataToUpdate;
    }

    private static final long serialVersionUID = 1L;
    private final int DEFAULT_WIDTH = 300,DEFAULT_HEIGHT = 300;
    private JList<String> list ;
    private String[] dataToUpdate ;
}