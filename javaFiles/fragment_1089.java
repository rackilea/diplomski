public <T extends Component> T GetComponent(Class<T> component) {
    for(Component c : components) {
        if(component.isInstance(c)) // check if c is an instance of component
            return (T) c;
    }

    return (T) null;
}