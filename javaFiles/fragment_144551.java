JComboBox<ClsPais> comboBox = new JComboBox<>();

    clsPais p1 = new clsPais();
    p1.setId(1);
    p1.setNombre("ARGENTINA");

    clsPais p2 = new clsPais();
    p2.setId(2);
    p2.setNombre("BRASIL");


    comboBox.addItem(p1);
    comboBox.addItem(p2);