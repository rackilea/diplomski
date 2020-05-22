public class ColorClass {
    public static void main(String[] args){
        int r = 255, g = 255, b = 255;
        Color rgb = new Color(r, g, b);

        for (int i = 0; i < 10; i++) {
            rgb = rgb.darker();
            System.out.println("After darker(): " + rgb);
        }

        for (int i = 0; i < 10; i++) {
            rgb = rgb.brighter();
            System.out.println("After brighter(): " + rgb);
        }
    }
}