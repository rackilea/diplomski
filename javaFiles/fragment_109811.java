public class SO2 {
  public static void main(String args[]) {
      GraphicsEnvironment g= null;
        g=GraphicsEnvironment.getLocalGraphicsEnvironment();
        String []fonts=g.getAvailableFontFamilyNames();
            for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
            if(fonts[i].equals("YOUR FONT")){
                System.out.println("Found!");
            }
    }

}}