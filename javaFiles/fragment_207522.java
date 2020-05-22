package javaopengl;

public class Main {
  public static void main(String[] args) {
    System.out.println("well, main works");
    Class checkjar = Class.forName("org.lwjgl.opengl.Display");
    System.out.println("My ClassLoader found: " + checkjar.getCanonicalName());
  }
}