import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MultiSpinner extends JFrame implements ChangeListener{
    JSpinner []sp ;
    public MultiSpinner(){
        sp = new JSpinner[10];

        //initialize spinners
        for(int i=0; i<sp.length; i++){
            sp[i] = new JSpinner();
            //this is important, i will be like and id of 
            //each spinner
            sp[i].setName(String.valueOf(i));
            sp[i].addChangeListener(this);
            add(sp[i]);
        }

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);


    }

    public void stateChanged(ChangeEvent e) {
        JSpinner temp = (JSpinner)e.getSource();
        int i = Integer.parseInt(temp.getName());//remmember? Name was like and ID
        System.out.println("Spinner "+i+" was clicked");
        //do whatever you want 
    }

    public static void main(String[]argS){
        new MultiSpinner();
    }
}