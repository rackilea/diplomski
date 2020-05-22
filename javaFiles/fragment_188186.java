components = getAllComponents(getComponents());
...
private HashMap<String, Component> getAllComponents(Component[] containerComponents) {
    HashMap<String, Component> comps = new HashMap<>();
    for (Component c : containerComponents) {
        comps.put(c.getName(), c);
        if (c instanceof Container) {
            comps.putAll(getAllComponents((Container) c).getComponents());
        }
    }

    return comps;
}