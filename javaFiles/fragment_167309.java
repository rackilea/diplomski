public void test(JPanel panel) {
    JList<Konsola> magazyn = new JList<>();
    DefaultListModel<Konsola> dlm = new DefaultListModel<>();
    addKonsola(dlm);
    magazyn.setModel(dlm);

    panel.add(magazyn);
}

public void addKonsola(DefaultListModel<Konsola> model) {
    model.addElement(new Konsola("PlayStation 2", 900, 240, "Sony Computer Entertainment", 32, 100));
    model.addElement(new Konsola("PlayStation 3", 1100, 800, "Sony Computer Entertainment", 256, 320000));
}