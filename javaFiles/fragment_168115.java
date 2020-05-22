public void Part2() {
    part2.setLayout(null);
    wellbox = new JComboBox(skills);
    System.out.println("wellbox created. hashcode: " + wellbox.hashCode());
    part2.add(wellbox);
    wellbox.setLocation(75, 120);
    wellbox.setSize(650, 40);
    wellbox.addItemListener(new ItemListener() {
        // @ Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("wellbox state change. hashcode: " + wellbox.hashCode());
                well = (wellbox.getSelectedIndex() - 1);
                System.out.println(well);
            }
        }
    });