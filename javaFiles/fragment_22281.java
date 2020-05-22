public interface ImageConsumer {
    public void imageLoaded(BufferedImage img);
}

public class Screen extends JPanel implements ImageConsumer {
    /*...*/

    private BufferedImage img;

    public Screen(){
        new ImageLoader(this).execute();
    }

    /*...*/

    public void imageLoaded(BufferedImage img) {
        this.img = img;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }

    protected class ImageLoader extends SwingWorker<BufferedImage, BufferedImage> {

        private ImageConsumer consumer;

        public ImageLoader(ImageConsumer consumer) {
            this.consumer = consumer;
        }

        @Override
        protected BufferedImage doInBackground() throws IOException {

            BufferedImage picture = ImageIO.read(new URL("Background.jpg"));
            return picture;

        }

        protected void done() {
            try {
                BufferedImage img = get();
                consumer.imageLoaded(img);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }           
    }
}