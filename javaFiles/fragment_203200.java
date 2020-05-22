JComboBox comboBox = new JComboBox();
ComboboxToolTipRenderer renderer = new ComboboxToolTipRenderer();
comboBox.setRenderer(renderer);
...
//make a loop as needed
comboBox.addItem(itemString);
tooltips.add(tooltipString);
...
renderer.setTooltips(tooltips);