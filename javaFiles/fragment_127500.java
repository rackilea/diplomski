class ComponentInfo {
    JComponent component;
    String key;

    public ComponentInfo(JComponent c,String k) {
        component = c;
        key = k;
    }

    public JComponent getComponent() {return component;}
    public String getKey() {return key;}
}