public static void main(String[] args)
{   
    Alpha_Core engine = new Alpha_Core();
    setDisplayMode(1280,720, "FullScreenMode"); 
    engine.Init_Program_Loop();
}

public static void setDisplayMode(int width, int height, String title)
{       
    Display.setTitle(title);
    DisplayMode displayMode = null;
        DisplayMode[] modes = Display.getAvailableDisplayModes();
         for (int i = 0; i < modes.length; i++)
         {
             if (modes[i].isFullscreenCapable())
               {
                    displayMode = modes[i];
               }
         }
        Display.setDisplayMode(displayMode);
        Display.setFullscreen(true);
        Display.create();
        Keyboard.create();
        Mouse.create();
    } 
    catch (LWJGLException e) 
    {
        e.printStackTrace();
    }
}