package org.stackoverflow;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class URLClassLoaderSample
{
  public static void main(String[] args) throws Exception
  {
    File f = new File("C:\\_programs\\apache\\log4j\\v1.1.16\\log4j-1.2.16.jar");
    URLClassLoader urlCl = new URLClassLoader(new URL[] { f.toURL()},System.class.getClassLoader());
    Class log4jClass = urlCl.loadClass("org.apache.log4j.Logger");
    log4jClass.newInstance();
  }
}



Exception in thread "main" java.lang.InstantiationException: org.apache.log4j.Logger
    at java.lang.Class.newInstance0(Class.java:357)
    at java.lang.Class.newInstance(Class.java:325)
    at org.stackoverflow.URLClassLoaderSample.main(URLClassLoaderSample.java:19)