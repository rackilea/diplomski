package org.rockislandschools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        if(args.length == 0)
        {
            System.out.println("Please specify IP Address.");
            System.exit(0);
        }

        String address = args[0];

        HostStatus status = new HostStatus();

        String currentState = status.IsReachableReturnString(address);

        JFrame statusFrame = new JFrame();

        statusFrame = DisplayStatus.buildFrame(address, currentState);

        //String newState = status.IsReachableReturnString(address);

        while (true){
            String newState = status.IsReachableReturnString(address);
            if (newState.equals(currentState)){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                System.out.println("Nothing has changed, Time is " + timeStamp );

            } else {
                //statusFrame.setVisible(false);
                statusFrame.dispose();
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                System.out.println("Building a new frame, Time is " + timeStamp);
                currentState = newState;
                statusFrame = DisplayStatus.buildFrame(address, currentState);
            }
        }
    }
}