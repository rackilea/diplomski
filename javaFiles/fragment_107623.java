import java.awt.*;
public class Main{

public static void main(String[] args) {

    try
    {
    Robot bot = new Robot();
    bot.mouseMove(50, 50);  
    }
    catch (AWTException e)
    {
    e.printStackTrace();
    }
}
}