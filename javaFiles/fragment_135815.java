import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TAScroll {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        JTextArea ta=new JTextArea();
        for (int i=0;i<50; i++) {
            ta.append(i+"\n");
        }
        final JScrollPane scroll=new JScrollPane(ta);
        f.add(scroll);

        Timer t=new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getValue()+10);
                if (scroll.getVerticalScrollBar().getValue()>=scroll.getVerticalScrollBar().getMaximum()) {
                    ((Timer)e.getSource()).stop();
                }
            }
        });

        t.start();

        f.setLocationRelativeTo(null);
        f.setSize(200,100);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}