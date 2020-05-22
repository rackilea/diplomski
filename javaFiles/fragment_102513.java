Component[] components = parentComponent.getComponents();

for(int i = 0; i < components.length; i++) {
    if(components[i].getName().equals(index)) {
        cardLayout.removeLayoutComponent(components[i]);
    }
}