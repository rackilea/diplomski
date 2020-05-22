m.addMenuListener(new MenuListener() {

    @Override
    public void menuSelected(MenuEvent e) {
        JMenu menu = (JMenu) e.getSource();
        menu.setIcon(core.getIcon("webmaps", "pressed"));
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        JMenu menu = (JMenu) e.getSource();
        menu.setIcon(core.getIcon(text, "normal"));
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        JMenu menu = (JMenu) e.getSource();
        menu.setIcon(core.getIcon(text, "normal"));
    }
});