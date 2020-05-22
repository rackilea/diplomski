JPanel panel1 = new JPanel();
    GridLayout layout = new GridLayout(4, 2);
//    layout.minimumLayoutSize(panel1);
    layout.setHgap(1);
    layout.setVgap(10);
    panel1.setLayout(layout);
    pane.addTab("Profile", panel1);

    Dimension dmtfs = nameField.getPreferredSize(); // default preferred text field size
    nameField.setPreferredSize(new Dimension(dmtfs.width, dmtfs.height-10)); // too small, but will be caught by height of text area 
    ageField.setPreferredSize(new Dimension(dmtfs.width, dmtfs.height-10));
    heightField.setPreferredSize(new Dimension(dmtfs.width, dmtfs.height-10));
    weightField.setPreferredSize(new Dimension(dmtfs.width, dmtfs.height-10));
    Dimension dmtas = nameArea.getPreferredSize(); // default preferred text area size
    nameArea.setPreferredSize(new Dimension(dmtas.width+10, dmtas.height));
    // changing one is enough, because GridLayout goes for the biggest