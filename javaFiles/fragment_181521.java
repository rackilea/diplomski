import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleEditor extends JFrame {

        /**
     * 
     */
    private static final long serialVersionUID = 1L;
        int count = 0;
        Container content = getContentPane();

        private JTextComponent[] textComp;
        // Create an editor.
        public SimpleEditor() {
                super("Swing Editor");
                dinamicTA();
                content.setLayout(new FlowLayout());

                for(int i=0;i<count;i++) {
                        content.add(textComp[i]);
                }

                pack();
                content.setSize(content.getPreferredSize());
                pack();
        }

        //create DINAMIC TEXT AREA
        public void dinamicTA () {
                if(count==0) {
                        textComp = new JTextComponent[1];
                        textComp[0] = createTextComponent();
                        count+=1;
                }
                else {
                        JTextComponent[] texttemp;
                        texttemp = textComp;
                        count+=1;
                        textComp = new JTextComponent[count];
                        for(int i=0;i<count-1;i++) {
                                textComp[i] = texttemp[i];
                                textComp[i].setText(textComp[i].getText()+"wow"); //<-- not working
                        }
                        textComp[count-1] = createTextComponent();
                        content.add(textComp[count-1]);
                        textComp[count-1].requestFocus(); //get focus
                }
        }

        // Create the JTextComponent subclass.
        protected JTextComponent createTextComponent() {
                final JTextArea ta = new JTextArea();
                if (count%2==0)
                        ta.setForeground(Color.red);
                else
                        ta.setForeground(Color.GREEN);
                ta.setFont(new Font("Courier New",Font.PLAIN,12));
                ta.setLineWrap(true);                                                                                                                           
                ta.setWrapStyleWord(true);  
                ta.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent ev) {
                                taKeyReleased(ev);
                        }
                });

                ta.setColumns(15);
                pack();
                ta.setSize(ta.getPreferredSize());
                pack();

                return ta;
        }

        private void taKeyReleased(java.awt.event.KeyEvent ev) { 
                int key = ev.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                        dinamicTA();
                        pack();
                        content.setSize(content.getPreferredSize());
                        pack();
                }
        }

        public static void main(String[] args) {
            SimpleEditor editor = new SimpleEditor();
            editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            editor.setVisible(true);
    }    
}