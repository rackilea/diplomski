import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

public class TimerPanel extends JPanel{
    private int min,sec;
    private String theTime = min + ":" + sec;
    private int width=350, height=300;
    private boolean timerStarted=false;
    private Timer swingTimer = new Timer(900, new ActionListener(){
        public void actionPerformed(ActionEvent event){
            if(sec<60){
                sec++;
                theTime = min + ":" + sec;
                repaint();
            }else{
                min++;
                sec=0;
                theTime = min + ":" + sec;
                repaint();
            }
        } 
    });
    //Constructor
    public TimerPanel(){

    setPreferredSize(new Dimension(350,300));
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //start the timer
    public void startTimer(){
        swingTimer.start();
    }

    //Stop the timer
    public void stopTimer(){
        swingTimer.stop();
    }

    //reset the timer
    public void resetTimer(){
        sec=0; min=0;
        theTime = min + ":" + sec;
        repaint();
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
    //Paint Method
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        g.drawString(theTime, width/2-45, height/2);
        setBackground(Color.BLACK);
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------  

}