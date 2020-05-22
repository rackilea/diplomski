@SuppressWarnings("serial")
class Traff2LightPanel extends JPanel {
    private Map<Light, Icon> lightColorMap = new EnumMap<>(Light.class);
    private JLabel imageLabel = new JLabel();
    private Light light = Light.NONE;

    public Traff2LightPanel() {
        // fill the map
        lightColorMap.put(Light.NONE, new ImageIcon("nonePic.png"));
        lightColorMap.put(Light.RED, new ImageIcon("redPic.png"));
        lightColorMap.put(Light.YELLOW, new ImageIcon("yellowPic.png"));
        lightColorMap.put(Light.GREEN, new ImageIcon("greenPic.png"));

        imageLabel.setIcon(lightColorMap.get(Light.NONE));
        add(imageLabel);
    }

    // when changing the light field, 
    // also set the ImageIcon
    public void setLight(Light light) {
        this.light = light;
        imageLabel.setIcon(lightColorMap.get(light));
    }

    public Light getLight() {
        return light;
    }
}