package org.app;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;


public class MainFrame extends JFrame{
    private static final long serialVersionUID = 1L;    
    private JDesktopPane theDesktop;
    private List<JInternalFrame> frameList=new ArrayList<>();

public MainFrame()  {
    super("Internal Frame Demo");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(800,600);
    this.setJMenuBar(setMenubar());
    theDesktop=new JDesktopPane();
    this.add(theDesktop);
    this.setVisible(true);
}

public JMenuBar setMenubar()    {
    JMenuBar bar=new JMenuBar();
    JMenu addMenu=new JMenu("Add");
    JMenuItem newFrame=new JMenuItem("Internal Frame");
    newFrame.addActionListener(new MenuAction());
    addMenu.add(newFrame);
    bar.add(addMenu);
    return bar;
}

public JInternalFrame addInternalFrame()    {
    JInternalFrame jif=new JInternalFrame("Internal frame",true,true,true,true);
    jif.setSize(new Dimension(240, 300));       
    jif.addInternalFrameListener(new InternalFrameAdapter() {
        @Override
        public void internalFrameClosing(InternalFrameEvent e){             
            frameList.remove(e.getInternalFrame());                 
            System.out.println("from frame closing event");         
        }
    });
    jif.show();
    return jif;
}   
public JInternalFrame getInternalFrame(int index)   {
    return frameList.get(index);
}   
class MenuAction implements ActionListener  {
    @Override
    public void actionPerformed(ActionEvent e) {            
        JInternalFrame f=addInternalFrame();
        theDesktop.add(f);
        frameList.add(f);           
        System.out.println("from menu action");
    }           
}   
public static void main(String[] args){
    new MainFrame();
}