package com.stackoverflow.test;

import java.net.URL;
import java.nio.file.Paths;

public class ClassPathUtils {

  public static String getBasePath(String jarPath) {
    String path = getJarPathFromClass(jarPath);
    if (path == null) {
      return null;
    }

    if (path.startsWith("jar:")) {
      path = path.substring("jar:".length());
    }
    if (path.startsWith("file:")) {
      path = path.substring("file:".length());
    }
    if (path.endsWith(jarPath)) {
      path = path.substring(0, path.length()-jarPath.length());
    }

    return path;
  }
  public static String getBasePath(Class clazz) {
    return getBasePath(classNameDotClass(clazz));
  }
  private static String classNameDotClass(Class clazz) {
    return clazz.getName().replaceAll("\\.", "/") + ".class";
  }
  private static String getJarPathFromClass(String resource) {
    final URL url = ClassPathUtils.class.getClassLoader().getResource(resource);
    return url == null ? null : url.toString();
  }
  public static void main(String[] args) {
    //System.out.println(Paths.get(ClassPathUtils.getBasePath("."))); // doesn't work in a jar
    System.out.println(Paths.get(ClassPathUtils.getBasePath(ClassPathUtils.class)));

    System.out.println(Paths.get(ClassPathUtils.getBasePath("fonts/atcitadelscript.ttf"))); // any classpath resource

    System.out.println(Paths.get(ClassPathUtils.getBasePath(String.class))); // actually finds rt.jar

  }
}