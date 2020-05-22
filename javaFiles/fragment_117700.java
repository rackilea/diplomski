JSlider slider = new JSlider(JSlider.VERTICAL, 0, 100, 0);
slider.setMinorTickSpacing(5);
slider.setMajorTickSpacing(10);
slider.setPaintTicks(true);
Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
labels.put(0, new JLabel("0"));
labels.put(100, new JLabel("100"));
slider.setLabelTable(labels);
slider.setPaintLabels(true);