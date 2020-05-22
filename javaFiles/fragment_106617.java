public class Program {
    public static void main(String[] args) {
        InputStream imageSource = Program.class.getResourceAsStream("bishop"); // may be a URL, File or ImageInputStream instead
        try {
            BufferedImage bishopImage = ImageIO.read(imageSource); // read image
            ImageIcon bishopIcon = new ImageIcon(bishopImage); // use adapter for Icon interface
            System.out.println(bishopIcon); // do something with it
        } catch (IOException e) {
            e.printStackTrace(); // read failed
        }
    }
}