String Xport = System.getProperty("lmportal.xvfb.id", ":1");

final File firefoxPath = new File(System.getProperty("lmportal.deploy.firefox.path", "/usr/bin/firefox"));

FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);

firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);