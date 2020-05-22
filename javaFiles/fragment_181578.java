while(!Display.isCloseRequested() && !Input.ESC())
//

public class Input
{
    public static boolean ESC() 
    {
        return Keyboard.isKeyDown(Keyboard.KEY_ESCAPE);
    }
}