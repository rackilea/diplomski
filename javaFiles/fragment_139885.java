import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//better practice is to have a `JFrame instance rather than extending it 
public class Traitform extends JFrame { 

    public Traitform (Model model) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(0,1);
        setLayout(layout);

        JRadioButton momEye1 = new JRadioButton("brown");
        JRadioButton momEye2 = new JRadioButton("blue");
        ButtonGroup group1 =  new ButtonGroup();
        group1.add(momEye1);
        group1.add(momEye2);

        class geneActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ex) {
                String choice = group1.getSelection().getActionCommand();
                model.setChoice(choice);
            }
        }

        ActionListener al = new geneActionListener();
        momEye1.addActionListener(al);
        momEye2.addActionListener(al);
        momEye1.setActionCommand("brown");
        momEye2.setActionCommand("blue");

        JPanel set1 = new JPanel();
        set1.add(momEye1);
        set1.add(momEye2);

        add(set1);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments){
        new Controller();
    }
}

//controls and "wires" view and model
class Controller{
    Model model = new Model();   //construct a model
    Traitform view = new Traitform(model);   //construct a view 
}

//holds information and logic used by view
class Model{
    private String choice;

    String getChoice() {
        return choice;
    }

    void setChoice(String choice) {
        this.choice = choice;
        System.out.println("choice in model changed to "+ choice);
    }
}