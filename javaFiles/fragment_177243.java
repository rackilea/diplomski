public static void main(String[] args) {
    JFrame f=new JFrame();
    String text="<html>An example of tag &lt;html&gt; with <font color='red'>&lt;input&gt;</font> tag colored</html>";
    f.add(new JLabel(text));
    f.pack();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
}