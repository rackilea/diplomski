import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.Lcd;

public class LCD {

    public final static int LCD_ROWS = 2;
    public final static int LCD_COLUMNS = 16;
    public final static int LCD_BITS = 4;

    public static  void main(String args[]) {

        System.out.println("SYSTEM PRINT TEST");

        if (Gpio.wiringPiSetup() == -1) {
            System.out.println("GPIO SETUP ERROR");
            return;
        }

        int lcdHandle= Lcd.lcdInit(LCD_ROWS,
                                   LCD_COLUMNS,
                                   LCD_BITS,
                                   6,
                                   5,
                                   15,
                                   16,
                                   1,
                                   4,
                                   0,
                                   0,
                                   0,
                                   0);

        if (lcdHandle == -1) {
            System.out.println("LCD INIT ERROR");
            return;
        }

        Lcd.lcdDisplay(lcdHandle,1);
        Lcd.lcdClear(lcdHandle);

        Lcd.lcdPuts (lcdHandle, "LCD TEST LINE 1") ;

        Lcd.lcdPosition (lcdHandle, 0, 1) ; 
        Lcd.lcdPuts (lcdHandle, "LCD TEST LINE 2") ;

try {
     Thread.sleep(10000);
    } catch (Exception e) {}
     Lcd.lcdDisplay(lcdHandle,0);  

    }
}