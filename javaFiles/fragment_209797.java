initComponents();

    //slider = new JSlider(JSlider.HORIZONTAL,0,10,5);
    slider.setMinimum(0);
    slider.setMaximum(10);
    slider.setValue(5);
    slider.setMinorTickSpacing(1);
    slider.setMajorTickSpacing(2);
    slider.setPaintTicks(true);

    //JOptionPane.showMessageDialog(null, slider);

    //setVisible(true);                              <<---- already set visible