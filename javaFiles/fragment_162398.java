@XmlElements({
    @XmlElement(name="ComboBox", type=ComboBox.class),
    @XmlElement(name="CheckBox", type="CheckBox.class)
})
public List<Component> getComponent() {
       if (component == null) {
           component = new ArrayList<Component>();
       }
       return this.component;
}