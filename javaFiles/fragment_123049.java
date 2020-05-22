@POST
public String MyPost(byte[] bytes) throws IOException  {
    JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(bytes)));
    System.out.println("Service invoked");
    return "Hello, I am a POST response";
}