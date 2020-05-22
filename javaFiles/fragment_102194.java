JComboBox box = new JComboBox();
        // Adds a listener - this performs an action when the item changes.
        box.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                //Checks if this event was caused because an item was selected
                if((e.getStateChange() & ItemEvent.SELECTED) == ItemEvent.SELECTED){
                    System.out.println(e.getItem());
                    // This is where you'd modify your label based on the dropdown's value - something like this:
                    label.setText("$900");
                }
            }});
        panel.add(box);