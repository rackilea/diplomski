public class CameraView extends JInternalFrame{

    private BufferedImage image;

    public CameraView(){
        super("Camera", false,false,false, false);

        setLocation(200,200);

        add(new JComponent() {

            {
                setSize(500, 500); // size of the image
            }

            @Override
            public void paint(Graphics g){
                g.drawImage(image, 0, 0, null);
            }

        });

        pack();
    }

   public void setImage(BufferedImage image){
       this.image = image;
   }
}