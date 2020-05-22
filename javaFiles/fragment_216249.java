import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main3 {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("!", "1");
            map.put("@", "2");
            map.put("#", "3");

            char[] charz = "abcdefgABCDEFG123!#".toCharArray();

            for(int i = 0; i < charz.length; i++)
            {
                System.out.print(charz[i] + " : ");
                boolean shiftRequired = false;
                String key = String.valueOf(charz[i]);
                String value = map.get(key);

                if (value != null)
                {
                    shiftRequired = true;
                    key = value;
                }
                else if (Character.isUpperCase(key.charAt(0)))
                {
                    shiftRequired = true;
                }
                else
                {
                    key = key.toUpperCase();
                }

                KeyStroke ks = KeyStroke.getKeyStroke("pressed " + key.toUpperCase());

                int keyCode = ks.getKeyCode();
                System.out.println(keyCode);

                if (shiftRequired)
                    robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT);

                robot.keyPress( keyCode );
                robot.keyRelease( keyCode );

                if (shiftRequired)
                    robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}