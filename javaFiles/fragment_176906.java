import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class Console extends JPanel{

    private JTextArea area;


    public Console(){
        this.setBorder(new TitledBorder("Console:"));
        area=new JTextArea();
        this.setLayout(new BorderLayout());
        JScrollPane scroll=new JScrollPane(area);
        this.add(scroll,BorderLayout.CENTER);
    }

    public void clear(){
        area.setText("");
    }
    public void write(String txt){

        area.append(txt+" "+"\n");

    }
  }