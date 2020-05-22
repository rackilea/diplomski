GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment()
        .getScreenDevices();
    for (int i = 0; i < devices.length; i++) {
        GraphicsDevice dev = devices[i];
        System.out.println("device " + i);
        DisplayMode[] modes = dev.getDisplayModes();
        for (int j = 0; j < modes.length; j++) {
            DisplayMode m = modes[j];
            System.out.println(" " + j + ": " + m.getWidth() + " x " + m.getHeight());
        }
    }