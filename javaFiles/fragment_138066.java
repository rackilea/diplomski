package jthndemo;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

public class JthnDEMO {

    public static void main(final String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(() -> {
            PrintStream out = System.out;
            int pause = 300;
            int progressbarLength = 15;
            boolean cond = true;
            String txt = "Extracting...please, wait ";
            String character = "█";
            String str = null;
            while (cond) {
                int i = 0;
                str = txt;
                out.print("\r" + str + character);
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JthnDEMO.class.getName()).log(Level.SEVERE, null, ex);
                }
                while (i < progressbarLength) {
                    str = txt;
                    for (int j = 0; j < i + 1; j++) {
                        str += character;
                    }
                    out.print("\r" + str);
                    try {
                        Thread.sleep(pause);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JthnDEMO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
                String blank = "";
                for (int k = 0; k < str.length(); k++) {
                    blank += " ";
                }
                out.print("\r" + blank);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JthnDEMO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}