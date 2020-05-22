@SuppressWarnings("serial")
class Traff2LightControlsPanel extends JPanel {
    private Traff2LightPanel lightPanel;

    public Traff2LightControlsPanel(Traff2LightPanel lightPanel) {
        this.lightPanel = lightPanel;
        for (Light light : Light.values()) {
            if (light == Light.NONE) {
                continue;
            }
            add(new JButton(new LightAction(light)));
        }
    }

    // use an AbstractAction... 
    // like an ActionListener on "steroids"
    private class LightAction extends AbstractAction {
        private Light light;

        public LightAction(Light light) {
            super(light.getText());
            this.light = light;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            lightPanel.setLight(light);
        }
    }    
}