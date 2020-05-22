public class customFrame extends JFrame{

    public customFrame() {
        try {
            this.setIconImage(ImageIO.read(new File("C:\\Users\\Madhawa.se\\Desktop\\gtg.PNG")));
        } catch (IOException ex) {
            Logger.getLogger(customFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}