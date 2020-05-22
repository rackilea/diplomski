class MainContainer extends JFrame {
    private List<JComponent> currentComponents = new ArrayList<JComponent>();

    public void addControl(JComponent newComp) {
        // -- add it to the JFrame --
        ...

        // -- make a note that it is on --
        currentComponents.add(newComp);
    }

    public void removeControl(JComponent oldComp) {
        // -- check if it is in the list --
        if (currentComponents.contains(oldComp)) {
            // -- remove it from the JFrame --
            ...

            // -- remove it from the list --
            currentComponents.remove(oldComp);
        }
    }
}