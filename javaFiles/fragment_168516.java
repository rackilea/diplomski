class Main extends JFrame {

    private static final int DT_WIDTH = 1920;
    private static final int DT_HEIGHT = 1080;
    private JDesktopPane container = new JDesktopPane();

    public Main(){
        super("JDesktopPane SS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);

        // setLayout(new ScrollPaneLayout()); // ?????

        // container.setBounds(new Rectangle(1920, 1080));
        container.setPreferredSize(new Dimension(DT_WIDTH, DT_HEIGHT));