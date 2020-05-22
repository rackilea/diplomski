@POST
public String MyPost(InputStream is) throws IOException  {
    BufferedImage image = ImageIO.read(is);
    JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)));
    System.out.println("Service invoked");
    return "Hello, I am a POST response";
}