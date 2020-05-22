import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class APanel extends JScrollPane {

    int width = 0;

    public APanel(){
        super();        

        final Box B = Box.createVerticalBox();

        for(int i = 0; i < 4; i++){
            B.add(new CPanel(){

                //Important!!! Make sure the width always fits the screen
                public Dimension getPreferredSize(){
                    Dimension result = super.getPreferredSize();
                    result.width = width - 20; // 20 is for the scroll bar width
                    return result;
                }

            });
        }

        setViewportView(B);

        //Important!!! Need to invalidate the Scroll pane, othewise it
        //doesn't try to lay out when the container is shrunk
        addComponentListener(new ComponentAdapter(){
            public void componentResized(ComponentEvent ce){
                width = getWidth();
                B.invalidate();
            }
        });
    }

    // nothing really very special in this class - mostly here for demonstration
    public static class CPanel extends JPanel{

        //Test Data - not necessary
        static StringBuffer fillerString;
        static {
            fillerString = new StringBuffer();
            int i = 0;
            for(char c = '0'; c < 'z'; c++){
                fillerString.append(c);
                if(i++ %10 == 0){
                    fillerString.append('\n');
                }
            }
        }

        public CPanel(){
            super(new WrapLayout());
            setOpaque(true);
            setBackground(Color.gray);

            //Adding test data (TextAreas)
            for(int i = 0; i < 9; i++){
                JTextArea ta = new JTextArea(fillerString.toString());
                ta.setAlignmentX(LEFT_ALIGNMENT);
                add(ta);
            }

            setBorder(BorderFactory.createTitledBorder("Lovely container"));
        }
    }

    public static void main(String[] args){
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new APanel());
        frame.pack();
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}