import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bank {
    private List<Accounts> list ;
    private JButton submit;
    //default Constructor
    public Bank(){
        list = new ArrayList<Accounts>();
        submit = new JButton("Submit");
        submit .addActionListener(this);
        /*
        will be alot of code if I create the whole frame 
        but suppose you have created your frame */
    }
    public void actionPerformed(ActionEvent ev){
      if(ev.getSource()==submit){
         Accounts ac = new Accounts(); 
         ac.setId("id.getText()");
         ac.setName("name.getText()");
        //...
        textArea.setText(ac.toString());//see it's easy 
        list.add(ac);
      }
    }
}