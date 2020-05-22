public Component getComponent(Class<? extends Component> componentClass) {
    for (Component component : getComponentList()) {
        if (componentClass.isInstance(component)) {
           return component;  
        }
    }
    return null; // Or throw an exception, potentially.
}