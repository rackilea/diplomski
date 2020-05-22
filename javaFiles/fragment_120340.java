// check if java.awt.Desktop is available on the current platform
java.awt.Desktop.isDesktopSupported();

// check the current platform and security policy will let you browse to a url
Desktop desktop = java.awt.Desktop.getDesktop();
desktop.isSupported(Desktop.Action.BROWSE);