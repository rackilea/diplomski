public class ImageTask implements Runnable {

    private String name;
    private int timeout;

    public ImageTask(String name, int timeout) {
        this.name = name;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            System.out.println(this);
            FramePool.ImageFrame frame = FramePool.INSTANCE.grab();
            frame.setImage(ImagePool.INSTANCE.grab(name));
            frame.setTimeout(timeout);
            frame.setVisible(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}