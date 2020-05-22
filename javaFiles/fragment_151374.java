import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogApplet extends JApplet {

    @Override
    public void init() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                initGUI();
            }
        };
        SwingUtilities.invokeLater(r);
    }

    public void initGUI() {
        JButton b = new JButton("Show Dialog");
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showDialog();
            }
        };
        b.addActionListener(listener);
        add(b);
    }

    private JDialog d;
    JTextArea output;
    int currentX = -1;
    Timer timer;

    public void showDialog() {
        if (d==null) {
            output = new JTextArea(5,20);
            Window w = SwingUtilities.windowForComponent(this);
            d = new JDialog(w, "Dialog", Dialog.ModalityType.MODELESS);
            //Dialog.ModalityType.TOOLKIT_MODAL);  //security
            //Dialog.ModalityType.DOCUMENT_MODAL);
            //Dialog.ModalityType.APPLICATION_MODAL);
            d.add(output, BorderLayout.CENTER);
            ActionListener al = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    StringBuilder sb = new StringBuilder();


                    sb.append("parent location: \t" +
                        d.getParent().getLocation() + "\n");
                    sb.append("parent location - screen: \t" +
                        d.getParent().getLocationOnScreen() + "\n");

                    System.out.print(sb.toString());

                    output.setText(sb.toString());
                    if (currentX>-1 && 
                        currentX!=d.getParent().getLocationOnScreen().getX() 
                        ) {
                        System.out.println( "Goodbye world!" );
                        d.setVisible(false);
                        timer.stop();
                    }
                }
            };
            timer = new Timer(1000, al);
            d.pack();
            d.setLocationRelativeTo(d.getParent());
        }
        currentX = (int)d.getParent().getLocationOnScreen().getX();
        timer.start();
        d.setVisible(true);
    }
}