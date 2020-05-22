// sets the look and feel to be that of the operating system's
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | 
        InstantiationException | 
        IllegalAccessException | 
        UnsupportedLookAndFeelException e) {
        e.printStackTrace();
    }