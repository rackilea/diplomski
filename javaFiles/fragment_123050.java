@POST
public String MyPost(File file) throws IOException  {
    BufferedImage image = ImageIO.read(file);
    JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)));
    System.out.println("Service invoked");
    return "Hello, I am a POST response";
}