import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Test extends JFrame{ //see https://www.javatpoint.com/java-naming-conventions

    private JLabel[] titles;
    private JLabel[] descriptions;
    private JPanel [] panels;
    private JScrollPane jScrollPane1;
    private JPanel bigPanel;
    private final static int NUM_OF_RESULTS =10;

    public Test() {

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(1000,500);             no need to set size. use preferred sizes
        //jScrollPane1.setSize(1000, 500);    and layouts. see following comments

        bigPanel = new JPanel();
        //set layout to
        GridLayout layout = new GridLayout(NUM_OF_RESULTS, 0);
        bigPanel.setLayout(layout);
        jScrollPane1 = new JScrollPane(bigPanel);
        getContentPane().add(jScrollPane1);

        requetezQuery();
        pack(); //see https://stackoverflow.com/questions/22982295/what-does-pack-do
        setVisible(true); //set visible typically comes last
    }
    public void requetezQuery(){

        titles = new JLabel[NUM_OF_RESULTS];
        descriptions = new JLabel[NUM_OF_RESULTS];
        panels = new JPanel[NUM_OF_RESULTS];

        for(int i = 0; i<NUM_OF_RESULTS; i++){

            String title="Test Title "+i;
            String resume="Test Resume "+i;

            titles[i]= new JLabel();
            descriptions[i]= new JLabel();
            panels[i]= new JPanel();
            panels[i].setPreferredSize(new Dimension(250, 50));
            panels[i].setLayout(new FlowLayout()); //FlowLayout is default for JPanel
            titles[i].setText(title);
            descriptions[i].setText(resume);
            titles[i].setForeground(Color.red);
            descriptions[i].setForeground(Color.red);
            panels[i].add(titles[i]);
            panels[i].add(descriptions[i]);
            bigPanel.add(panels[i],i, 0);
        }
    }

    public static void main(String args[]){
        new Test();
    }
}