package org.eclipse.jetty.util;

public class Jetty {
  public static final String VERSION;

  private Jetty() {
  }

  static {
    Package pkg = Jetty.class.getPackage();
    if(pkg != null && "Eclipse.org - Jetty".equals(pkg.getImplementationVendor()) && pkg.getImplementationVersion() != null) {
      VERSION = pkg.getImplementationVersion();
    } else {
      VERSION = System.getProperty("jetty.version", "9.2.z-SNAPSHOT");
    }

  }
}