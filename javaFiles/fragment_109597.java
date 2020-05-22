public class Main {
   public static void main(String[] args) {
      LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
      System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
      config.title = "Mygame"; 
      config.width = 1920;
      config.height = 1080;
      new LwjglApplication(new MyGame(), config);
   }
}