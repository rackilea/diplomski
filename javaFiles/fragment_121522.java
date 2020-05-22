if(System.getProperty("os.name").toUpperCase().startsWith("MAC")) {
System.setProperty("com.apple.mrj.application.apple.menu.about.name", "My App Name");
System.setProperty("apple.awt.application.name", "My App Short name");
//Need for macos global menubar
System.setProperty("apple.laf.useScreenMenuBar", "true");

try {
    Class application = Class.forName("com.apple.eawt.Application");
    Method getApplication = application.getMethod("getApplication");
    Object instance = getApplication.invoke(application);

    Class[] params = new Class[1];
    params[0] = Image.class;
    Method setIcon = application.getMethod("setDockIconImage",params);
    setIcon.invoke(instance,Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("images/icon.png")));

} catch (ClassNotFoundException | NoSuchMethodException |
        SecurityException | IllegalAccessException |
        IllegalArgumentException | InvocationTargetException exp) {
    exp.printStackTrace(System.err);
}
}