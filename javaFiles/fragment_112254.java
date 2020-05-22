public class staffGUI extends JFrame {

    public staffGUI(){
        super("Staff Management");

        this.setContentPane(new MyContentPane("C://somePath//image.jpg"));

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
    }

    private class MyContentPane extends JPanel
    {
         private BufferedImage image;

         public MyContentPane(String path){
               try{
                     image = ImageIO.read(new File(path));
               }catch(IOException e){
                     e.printStackTrace();

                     image = new BufferedImage(100 , 100 , BufferedImage.TYPE_INT_ARGB);
                     Graphics g = image.getGraphics();
                     g.setColor(Color.blue);
                     g.fillRect(0 , 0 , 100 , 100);
                     g.dispose();
         }

         public void paintComponent(Graphics g){
              super.paintComponent(g);

              g.drawImage(image , 0 , 0 , getWidth() , getHeight() , null);
         }
    }
}