public void harvestJLabels(Container c, List<JLabel> l) {
    Component[] components = c.getComponents();
    for(Component com : components) {
        if(com instanceof JLabel) {
            l.add((JLabel) com);
        } else if(com instanceof Container) {
            harvestJLabels((Container) com, l));
        }
    }
}