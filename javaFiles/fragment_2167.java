public class TabView extends Form {

    private Tabs tabs;

    public TabView() {
        super("Radio Web", new BorderLayout());
        tabs = new Tabs(Component.BOTTOM);
        addComponent(BorderLayout.CENTER, tabs);
        tabs.setSwipeActivated(false);

        Component component = null;

        Button playButton = new  Button(FontImage.createMaterial(FontImage.MATERIAL_PLAY_ARROW,     UIManager.getInstance().getComponentStyle("Title"), 10));

        playButton.getAllStyles().setBorder(RoundBorder.create().color(0x94170C));
        playButton.getAllStyles().setMarginBottom(0);
        playButton.getAllStyles().setMarginLeft(0);
        playButton.getAllStyles().setMarginTop(0);
        Label mediaInfoLabel = new Label("Artist - Title");
        mediaInfoLabel.getAllStyles().setPaddingTop(2);
        mediaInfoLabel.getAllStyles().setPaddingBottom(2);
        Slider volumeSlider = new Slider();
        volumeSlider.setMinValue(0);
        volumeSlider.setMaxValue(100);
        volumeSlider.setEditable(true);
        Container box = GridLayout.encloseIn(1, new Container(), volumeSlider, mediaInfoLabel);

        Container south = new Container(new FlowLayout(Component.LEFT, Component.BOTTOM));


        south.add(playButton).add(box);

        paintBackgroundRect2Colors(south);

        component = BorderLayout.south(south);
        component.getAllStyles().setBgPainter(new BackgroundPainter(component) {
            @Override
            public void paint(Graphics g, Rectangle rect) {
                int color = g.getColor();
                int alpha = g.getAlpha();

                g.setColor(0x150100);
                g.setAlpha(255);
                g.fillRect(0, 0, rect.getWidth(), rect.getHeight());
                g.setColor(color);
                g.setAlpha(alpha);
            }
        });
        tabs.addTab("", FontImage.MATERIAL_AUDIOTRACK, 5, component);

        BrowserComponent sito = new BrowserComponent();
        sito.setURL("https://www.codenameone.com");
        tabs.addTab("", FontImage.MATERIAL_HTTP, 5, sito);

        BrowserComponent fb = new BrowserComponent();
        fb.setURL("https://www.facebook.com");
    tabs.addTab("", FontImage.MATERIAL_FACE, 5, fb);
    }

    public static void paintBackgroundRect2Colors(Component cmp) {
        Image i = Image.createImage(cmp.getPreferredW(), cmp.getPreferredH(), 0xffffff);
        Graphics g = i.getGraphics();
        g.setAntiAliased(true);
        boolean antiAliased = g.isAntiAliased();
        int y = i.getHeight() / 2;

        // Top half
        g.setAlpha(255); //Change this to 0 if you want top half to be transparent
        g.setColor(0x150100); // Change this to any color you want, I used "component" color just to blend the look and feel
        g.fillRect(0, 0, i.getWidth(), y);

        // Bottom half
        g.setAlpha(255);
        g.setColor(0xD12115);
        g.fillRect(0, y, i.getWidth(), i.getHeight());

        g.setAntiAliased(antiAliased);

        // Set background image and make sure it fills 
        cmp.getAllStyles().setBgImage(i, true);
        cmp.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL, true);
    }

}