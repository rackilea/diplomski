public class DrawImage extends JPanel
{

    BufferedImage image;

    public DrawImage() throws IOException {
        getFile();
    }

    public void getFile() throws IOException
    {
        image = ImageIO.read(new File("grass.png"));
    }

//...

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DrawImage pane = new DrawImage();
                    JFrame frame = new JFrame();
                    frame.add(pane);
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    frame.setSize(400, 400);
                    frame.setVisible(true);    
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }