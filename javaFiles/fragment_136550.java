public enum PictureWindowManager {

    INSTANCE;

    private Map<Image, List<JInternalFrame>> mapWindows;

    private PictureWindowManager(){

        mapWindows = new HashMap<>(25);

    }

    public JInternalFrame createWindowFor(Image image) {

        List<JInternalFrame> frames = mapWindows.get(image);
        if (frames == null) {
            frames = new ArrayList<>(25);
            mapWindows.put(image, frames);
        }
        JInternalFrame frame = new JInternalFrame("Picture");
        frame.add(new JScrollPane(new JLabel(new ImageIcon(image))));
        frames.add(frame);

        return frame;

    }

    public List<JInternalFrame> getFromFor(Image image) {

        JInternalFrame frame = null;
        return mapWindows.get(image);

    }
}