public static synchronized Toolkit getDefaultToolkit() {
    if (toolkit == null) {
        try {
            java.lang.Compiler.disable();

            java.security.AccessController.doPrivileged(
                    new java.security.PrivilegedAction<Void>() {
                public Void run() {
                    String nm = null;
                    Class<?> cls = null;
                    try {
                        nm = System.getProperty("awt.toolkit");
                        try {
                            cls = Class.forName(nm);
                        } catch (ClassNotFoundException e) {
                            ClassLoader cl = ClassLoader.getSystemClassLoader();
                            if (cl != null) {
                                try {
                                    cls = cl.loadClass(nm);
                                } catch (ClassNotFoundException ee) {
                                    throw new AWTError("Toolkit not found: " + nm);
                                }
                            }
                        }
                        if (cls != null) {
                            toolkit = (Toolkit)cls.newInstance();
                            if (GraphicsEnvironment.isHeadless()) {
                                toolkit = new HeadlessToolkit(toolkit);
                            }
                        }
                    } catch (InstantiationException e) {
                        throw new AWTError("Could not instantiate Toolkit: " + nm);
                    } catch (IllegalAccessException e) {
                        throw new AWTError("Could not access Toolkit: " + nm);
                    }
                    return null;
                }
            });
            loadAssistiveTechnologies();
        } finally {
            // Make sure to always re-enable the JIT.
            java.lang.Compiler.enable();
        }
    }
    return toolkit;
}