import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JApplet;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.border.Border;
/**
 *
 * @author IC
 */
public class taxiCab extends JApplet implements ActionListener {
    private JTextField speed, distance, fare, fuel, ov, full, tf, tf_fuel, tf_speed;
    private JButton butt, start, butt_pass, butt_sUp, butt_sDown, butt_refuel;
    private JLabel label;
    private JPanel main, north, south, south_left, south_right, center, center_content, north_speed, north_distance, north_fuel, north_fare;
    private Container contain;
    private int speedVal, distanceVal, passval, thread_sleep, status_width, fuel_width;
    private float fuelVal, fareVal;
    private Graphics g;
    private String status;
    private Font font2 = new Font("Kozuka Gothic Pro B", Font.BOLD, 60);
    private Border border2 = BorderFactory.createLineBorder(Color.black, 3);
    private Border border1 = BorderFactory.createLineBorder(Color.black, 1);
    private final int width_ = 500;
    private final int height_ = 300;
    Thread thread1 = new trd1();
    Thread thread2 = new trd2();
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        setSize(width_,height_);
        status = new String();
        status = "VACANT";
        status_width = -330;
        Border border3 = BorderFactory.createLineBorder(Color.black, 5);
                thread1 = new trd1();
                thread2.start();
                thread2.suspend();
        contain = new Container();
        contain = getContentPane();
        main = new JPanel(new BorderLayout());
            north = new JPanel(new GridLayout(2,2));
            north.setBackground(Color.blue);
                north_speed = new JPanel();
                    tf_speed = new JTextField(10);
                    tf_speed.setBorder(border1);
                    tf_speed.setText("Speed");
                    tf_speed.setHorizontalAlignment(JTextField.CENTER);
                    tf_speed.setBackground(Color.CYAN);
                    tf_speed.setEditable(false);
                    speed = new JTextField(10);
                    speed.setBorder(border1);
                    speed.setEditable(false);
                    speed.setText("-");
                    speed.setHorizontalAlignment(JTextField.CENTER);
                    north_speed.add(tf_speed);
                    north_speed.add(speed);
                north_distance = new JPanel();
                    tf = new JTextField(10);
                    tf.setBorder(border1);
                    tf.setText("Distance");
                    tf.setHorizontalAlignment(JTextField.CENTER);
                    tf.setBackground(Color.CYAN);
                    tf.setEditable(false);
                    distance = new JTextField(10);
                    distance.setBorder(border1);
                    distance.setEditable(false);
                    distance.setText("-");//<----------------------------------distance
                    distance.setHorizontalAlignment(JTextField.CENTER);
                    north_distance.add(tf);
                    north_distance.add(distance);
                north_fuel = new JPanel();
                    tf_fuel = new JTextField(10);
                    tf_fuel.setBorder(border1);
                    tf_fuel.setText("Fuel");
                    tf_fuel.setHorizontalAlignment(JTextField.CENTER);
                    tf_fuel.setBackground(Color.CYAN);
                    tf_fuel.setEditable(false);
                    fuel = new JTextField(10);
                    fuel.setBorder(border1);
                    fuel.setEditable(false);
                    fuel.setText("-");
                    fuel.setHorizontalAlignment(JTextField.CENTER);
                    north_fuel.add(tf_fuel);
                    north_fuel.add(fuel);
                north_fare = new JPanel();
                    tf = new JTextField(10);
                    tf.setBorder(border1);
                    tf.setText("Fare");
                    tf.setHorizontalAlignment(JTextField.CENTER);
                    tf.setBackground(Color.CYAN);
                    tf.setEditable(false);
                    fare = new JTextField(10);
                    fare.setBorder(border1);
                    fare.setEditable(false);
                    fare.setText("-");
                    fare.setHorizontalAlignment(JTextField.CENTER);
                    north_fare.add(tf);
                    north_fare.add(fare);
                north.add(north_speed);
                north.add(north_distance);
                north.add(north_fuel);
                north.add(north_fare);
            center = new JPanel(new BorderLayout(3,3));
                center_content = new JPanel(new GridLayout(2,1,0,15));
                    ov = new JTextField(20);
                    ov.setText("");
                    ov.setBackground(Color.yellow);
                    ov.setEditable(false);
                    ov.setBorder(border2);
                    full = new JTextField(20);
                    full.setHorizontalAlignment(JTextField.CENTER);
                    full.setText("FUELMeter");
                    full.setIgnoreRepaint(true);
                    full.setFont(font2);
                    full.setBorder(border2);
                    center_content.add(ov);
                    center_content.add(full);
                center.add(center_content, "Center");
                center_content.setBackground(Color.yellow);
                label = new JLabel("   ");
                center.add(label, "North");
                label = new JLabel("   ");
                center.add(label, "West");
                label = new JLabel("   ");
                center.add(label, "South");
                label = new JLabel("   ");
                center.add(label, "East");
            south = new JPanel(new BorderLayout());
                south_left = new JPanel(new GridLayout(2,1));
                    butt_sUp = new JButton("Speed Up");
                    butt_sUp.setBorder(border1);
                    butt_sUp.addActionListener(this);
                    butt_sUp.setEnabled(false);
                    south_left.add(butt_sUp);
                    butt_sDown = new JButton("Speed Down");
                    butt_sDown.setBorder(border1);
                    butt_sDown.addActionListener(this);
                    butt_sDown.setEnabled(false);
                    south_left.add(butt_sDown);
                south_right = new JPanel(new GridLayout(2,1));
                    butt_pass = new JButton("Passenger In");
                    butt_pass.setBorder(border1);
                    butt_pass.addActionListener(this);
                    butt_pass.setEnabled(false);
                    south_right.add(butt_pass);
                    butt_refuel = new JButton("Refuel");
                    butt_refuel.setBorder(border1);
                    butt_refuel.addActionListener(this);
                    butt_refuel.setEnabled(false);
                    south_right.add(butt_refuel);
                butt = new JButton("Start");
                butt.setBorder(border1);
                    butt.addActionListener(this);
                south.add(butt, "Center");
                south.add(south_left, "West");
                south.add(south_right, "East");
        north.setBorder(border1);
        center.setBorder(border1);
        south.setBorder(border1);
        center.setBackground(Color.yellow);
        main.add(north, "North");
        main.add(center, "Center");
        main.add(south, "South");
        main.setBorder(border1);
        //main.setIgnoreRepaint(true);
        contain.add(main);
        contain.setVisible(true);
        //contain.setIgnoreRepaint(true);


    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.setFont(font2);
        g.drawString(status, status_width, 140);
        g.setColor(Color.yellow);
        g.fillRect(2,82,12,70);
        g.fillRect(getWidth()-14,82,12,70);
        g.setColor(Color.black);
        g.fillRect(0,82,2,70);
        g.setColor(Color.GREEN);
        g.fillRect(17,(getHeight()/2)+20,fuel_width,getHeight()-(83+(getHeight()/2)));
        main.setBorder(border1);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Start"){
            butt.setLabel("Stop");
            butt_pass.setEnabled(true);
            fuelVal =  50.00f;
            distanceVal = 0;
            fareVal = 40.00f;
            speedVal = 0;
            fuel.setText(String.valueOf(fuelVal) + " L");
            distance.setText(String.valueOf(distanceVal) + " km");
            fare.setText("Php " + String.valueOf(fareVal));
            speed.setText(String.valueOf(speedVal) + " kph");
                thread1 = new trd1();
                thread1.start();
                thread2 = new trd2();
                thread2.start();
            //BufferedWriter bw;<-----------------------------------------------
            }
        else if(e.getActionCommand() == "Stop"){
            butt.setLabel("Start");
            butt_pass.setEnabled(false);
            butt_sUp.setEnabled(false);
            butt_sDown.setEnabled(false);
            butt_refuel.setEnabled(false);
            butt_pass.setLabel("Passenger In");

            thread1.stop();
        }
        else if(e.getActionCommand() == "Speed Up"){
            if(speedVal == 0){
                speedVal+=25;
                speed.setText(String.valueOf(speedVal) + " kph");
                butt_sDown.setEnabled(true);
                tf_speed.setText("Speed");
                thread1 = new trd1();
                thread1.start();
            }
            else if(speedVal == 275){
                speedVal+=25;
                speed.setText(String.valueOf(speedVal) + " kph");
                //butt_sUp.setEnabled(false);
                tf_speed.setText("MAX SPEED");
            }
            else{
                speedVal+=25;
                speed.setText(String.valueOf(speedVal) + " kph");
                }
        }
        else if(e.getActionCommand() == "Speed Down"){
            repaint();
            if(speedVal==25){
                speedVal-=25;
                speed.setText(String.valueOf(speedVal) + " kph");
                tf_speed.setText("S T O P P E D");
                butt_sDown.setEnabled(false);
            }
            else if(speedVal == 300){
                speedVal-=25;
                speed.setText(String.valueOf(speedVal) + " kph");
                tf_speed.setText("Speed");
                butt_sUp.setEnabled(true);
            }
            else{
                speedVal-=25;
                speed.setText(String.valueOf(speedVal) + " kph");
            }
        }
        else if(e.getActionCommand() == "Passenger In"){
            butt_pass.setLabel("Passenger Out");
            fareVal = 40.0f;
            fare.setText("Php " + String.valueOf(fareVal));
            butt_sUp.setEnabled(true);
            butt_sDown.setEnabled(true);
            butt_refuel.setEnabled(true);
            speedVal = 25;
            speed.setText(String.valueOf(speedVal) + " kph");
            status = "OCCUPIED";
                thread1 = new trd1();
                thread1.start();


        }
        else if(e.getActionCommand() == "Passenger Out"){
            status = "VACANT";
            butt_pass.setLabel("Passenger In");
            thread1.stop();
        }
        else if(e.getActionCommand() == "Refuel"){
            if(fuelVal == 0.0f){
                fuelVal = 50.00f;
                fuel.setText(String.valueOf(fuelVal));
                tf_fuel.setBackground(Color.cyan);
                tf_fuel.setText("Fuel");
                        fuel_width = (int)((getWidth()-34)*fuelVal/50f);
                thread1 = new trd1();
                thread1.start();
            }
            else{
                fuelVal = 50.00f;
                fuel.setText(String.valueOf(fuelVal) + " L");
            }
        }
    }

    public class trd1 extends Thread implements Runnable {

        public void run(){
            if(fuelVal>0.00f || speedVal>0){
                for(;;){
                    try {
                        Thread.sleep(50000/speedVal);
                        if(fuelVal == 0.00f || speedVal == 0)
                            thread1.stop();
                        distanceVal++;
                        fareVal += 1.00;
                        fuelVal -=.25f;
                        fuel_width = (int)((getWidth()-34)*fuelVal/50f);
                        repaint();
                        distance.setText(String.valueOf(distanceVal)+" km");
                        fuel.setText(String.valueOf(fuelVal)+" L");
                        fare.setText("P " + String.valueOf(fareVal));
                    } catch (InterruptedException e) {
                    }
                }
            }
            }
        }
    public class trd2 extends Thread implements Runnable {
        //tf_fuel = new JTextField(15);

        public void run(){
                for(int b = 0;;b++){
                    try {
                        Thread.sleep(10);
                        status_width +=1;
                        if(status_width == getWidth())
                            status_width = -330;
                        repaint();
                        if(fuelVal == 0.0f){
                            if(b%2==0){
                                tf_fuel.setBackground(Color.red);
                                tf_fuel.setText("R E F U E L");
                                }
                            else{
                                tf_fuel.setBackground(Color.cyan);
                                tf_fuel.setText("R E F U E L");
                                }
                        }
                    } catch (InterruptedException e) {
                    }
                }


        }
    }
}