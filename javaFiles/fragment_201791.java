private void loadSwtJar() {
    try {
        Class.forName (ORG_ECLIPSE_SWT_WIDGETS_SHELL);
        return;
    } catch (ClassNotFoundException e) {
        System.out.println (" ! Need to add the proper swt jar: "+e.getMessage());
    }

    String osName = System.getProperty("os.name").toLowerCase();
    String osArch = System.getProperty("os.arch").toLowerCase();

    //NOTE - I have not added the mac and *nix swt jars.
    String osPart = 
        osName.contains("win") ? "win" :
        osName.contains("mac") ? "cocoa" :
        osName.contains("linux") || osName.contains("nix") ? "gtk" :
        null;

    if (null == osPart)
        throw new RuntimeException ("Cannot determine correct swt jar from os.name [" + osName + "] and os.arch [" + osArch + "]");

    String archPart = osArch.contains ("64") ? "64" : "32";

    System.out.println ("Architecture and OS == "+archPart+"bit "+osPart);

    String swtFileName = "swt_" +osPart + archPart +".jar";
    String workingDir = System.getProperty("user.dir");
    String libDir = "\\lib\\";
    File file = new File(workingDir.concat(libDir), swtFileName);
    if (!file.exists ())
        System.out.println("Can't locate SWT Jar " + file.getAbsolutePath());

    try {
        URLClassLoader classLoader = (URLClassLoader) getClass().getClassLoader ();
        Method addUrlMethod = URLClassLoader.class.getDeclaredMethod ("addURL", URL.class);
        addUrlMethod.setAccessible (true);

        URL swtFileUrl = file.toURI().toURL();
        //System.out.println("Adding to classpath: " + swtFileUrl);
        addUrlMethod.invoke (classLoader, swtFileUrl);
    }
    catch (Exception e) {
        throw new RuntimeException ("Unable to add the swt jar to the class path: " + file.getAbsoluteFile (), e);
    }
}