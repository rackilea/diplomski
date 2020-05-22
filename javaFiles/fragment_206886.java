import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class JavaGui129 extends JFrame{
    public JavaGui129(){
        setupGUI();
        this.getContentPane().add(b);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    /*This method is used to add components into each other, setting layout, etc*/
    public void setupGUI(){
        //play.setPreferredSize(new Dimension(24,24));
        Box controls = Box.createHorizontalBox();
        controls.add(play);
        controls.add(Box.createHorizontalStrut(10));
        // Red letter day..
        timerLabel.setForeground(Color.RED);
        controls.add(timerLabel);
        controls.add(Box.createHorizontalStrut(200));
        locationLabel.setForeground(Color.GREEN);
        controls.add(locationLabel);
        b.add(controls);
    }
    /* Creating the gradient background */
    protected class Background extends JPanel{
        @Override
        protected void paintComponent(Graphics g){
            // very important! 
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            int w = this.getWidth();
            int h = this.getHeight();
            Color color1 = Color.black;
            Color color2 = Color.DARK_GRAY.brighter();
            GradientPaint gr = new GradientPaint(0,0,color1,0,w/2,color2);
            g2D.setPaint(gr); //Color changes to the gradient color
            g2D.fillRect(0, 0, w, h);
            // irrelevant now
            //g2D.setPaint(Color.white); //Color changes to white for JLabel, but doesn't actually change
        }

        @Override 
        public Dimension getPreferredSize() {
            return (new Dimension(400,100));
        }
    }
    /*Creating the combined Play and Pause button using AbstractAction 
     * The displayed icon must change from that of play to pause on click and vice versa*/
    protected class PlayAction extends AbstractAction{
        public PlayAction(){
            this.putValue(AbstractAction.LARGE_ICON_KEY, playIcon);
            this.putValue(SHORT_DESCRIPTION, "Click to Record Video");
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if(isPlay == true){
                isPlay = false;
                play.getAction().putValue(LARGE_ICON_KEY, pauseIcon);
                play.getAction().putValue(SHORT_DESCRIPTION,"Click to Pause Recording");
                JavaGui129.this.setState(JFrame.ICONIFIED);
                play.repaint();
            }else{
                isPlay = true;
                play.getAction().putValue(LARGE_ICON_KEY, playIcon);
                play.getAction().putValue(SHORT_DESCRIPTION,"Click to Start Recording");
                play.repaint();
            }
        }
        boolean isPlay = true; //true represents recorder is ready, false means it is currently recording
        Icon playIcon = (Icon) new ImageIcon("src/images/play.png");
        Icon pauseIcon = (Icon) new ImageIcon("src/images/pause.png");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new JavaGui129();
            }
        });
    }
    Background b = new Background();
    JButton play = new JButton(new PlayAction());
    JLabel timerLabel = new JLabel("00:00",JLabel.CENTER);
    JLabel locationLabel = new JLabel("Into: ",JLabel.LEFT);
}