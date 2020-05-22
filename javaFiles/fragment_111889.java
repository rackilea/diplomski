import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SecondForm extends JFrame {
    Vector fbtns = new Vector();
    int fshowbtncount=1;
    GridBagConstraints gbc = new GridBagConstraints();
    public SecondForm(){
        setSize(200, 200);
        setLocation(201, 0);
        getContentPane().setLayout(new GridBagLayout());
        fbtns.add(new JButton("Button ".concat(String.valueOf(fbtns.size()+1))));
        invalidateForm();
    }
    private void invalidateForm(){
       gbc.fill = GridBagConstraints.VERTICAL;
       for (int i=0; i<fbtns.size(); i++) {
           getContentPane().remove((Component)fbtns.get(i));
       }
       int y=0;
       for (int i=0; i<fshowbtncount; i++) {
           gbc.gridx=0;
           gbc.gridy=y++;
           getContentPane().add((Component)fbtns.get(i),gbc);
       }
       pack();
       invalidate();
    }
    public void setBtnCount(int cnt){
      if (cnt>=0 && cnt!=fshowbtncount) {
          fshowbtncount = cnt;
          while (fbtns.size()<cnt) {
            fbtns.add(new JButton("Button ".concat(String.valueOf(fbtns.size()+1))));    
          }
          invalidateForm();
      }  
    }
}