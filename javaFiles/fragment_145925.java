/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialportftdi;

import com.embeddedunveiled.serial.SerialComManager;
import com.embeddedunveiled.serial.SerialComManager.BAUDRATE;
import com.embeddedunveiled.serial.SerialComManager.DATABITS;
import com.embeddedunveiled.serial.SerialComManager.FLOWCONTROL;
import com.embeddedunveiled.serial.SerialComManager.PARITY;
import com.embeddedunveiled.serial.SerialComManager.STOPBITS;


/**
 *
 * @author Alexandros
 */
public class SerialPortFTDI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SerialComManager scm = new SerialComManager();
            long handle = scm.openComPort("COM4", true, true, true);
            scm.configureComPortData(handle, DATABITS.DB_8, STOPBITS.SB_1, PARITY.P_NONE, BAUDRATE.B115200, 0);
            scm.configureComPortControl(handle, FLOWCONTROL.NONE, 'x', 'x', false, false);
            scm.writeString(handle, "testing hello", 0); //== true);
            String data = scm.readString(handle);
            System.out.println("data read is :" + data);
            scm.closeComPort(handle);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }   
}