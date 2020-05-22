public class FrameFactory {
    public static JFrame createFrameWithTitle(String title) {
        JFrame frame = new JFrame(title);
        return frame;
    }

    public static JFrame createNonResizableFrameWithTitle(String title) {
        JFrame frame = createFrameWithTtitle(title);
        frame.setResizable(false);
        return frame;
    }
    //...
}