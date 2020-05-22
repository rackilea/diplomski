public TransmissionFrame() {
        initComponents();

        init();
    }

 private void init() {
JLabel label = new JLabel("Java Technology Dive Log");
ImageIcon image = null;
try {
    image = new ImageIcon(ImageIO.read(new URL("http://i.imgur.com/6mbHZRU.png")));
} catch(MalformedURLException mue) {
    mue.printStackTrace();
} catch(IOException ioe) {
    ioe.printStackTrace();
} 
label.setIcon(image);
jPanelImage.setLayout(new FlowLayout()); 
jPanelImage.add(label);

}