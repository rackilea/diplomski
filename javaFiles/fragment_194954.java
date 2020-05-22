public Component getComponent(Class<? extends Component> componentClass) {
    for (Component component : getComponentList()) {
        if (componentClass == component.getClass()) {
           return component;  
        }
    }
    return null; // Or throw an exception, potentially.
}