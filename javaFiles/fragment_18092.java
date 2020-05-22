DisplayMode displayMode = null;
        DisplayMode[] modes = Display.getAvailableDisplayModes();

         for (int i = 0; i < modes.length; i++)
         {
             if (modes[i].isFullscreenCapable())
               {
                    displayMode = modes[i];
               }
         }