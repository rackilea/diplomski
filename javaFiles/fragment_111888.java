import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FirstForm extends JFrame {
    JButton fbtn  = new JButton("Show F2");
    JSlider fslider = new JSlider(1, 10);
    SecondForm fsecond = new SecondForm();
    public FirstForm(){
        setSize(200,200);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(fbtn,BorderLayout.NORTH);
        getContentPane().add(fslider,BorderLayout.CENTER);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        fbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fsecond.setVisible(true);
            }
        });
        fslider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fsecond.setBtnCount(fslider.getValue());
            }
        });
    }
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
        public void run() {
                new FirstForm().setVisible(true);
            }
        });
    }
}