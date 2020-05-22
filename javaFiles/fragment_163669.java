JComboBox<String> unity = new JComboBox<>();
    unity.setBounds(430, 280, 140, 25);
    unity.setEditable(true);
    uy.add(unity);

    JLabel city = new JLabel("City:");
    city.setBounds(350, 320, 100, 25);
    city.setForeground(Color.BLACK);
    uy.add(city);

    JComboBox<String> cety = new JComboBox<>();
    cety.setBounds(430, 320, 140, 25);
    uy.add(cety);

    unity.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent event) {
            cety.removeAllItems();
            cety.addItem("");
            switch (event.getItem().toString()) {
                case "Pakistan":
                    cety.addItem("Lahore");
                    cety.addItem("Islamabad");
                    cety.addItem("Karachi");
                    cety.addItem("Rawalpindi");
                    cety.addItem("Faisalabad");
                    cety.addItem("Gujjranwala");
                    break;
                case "China":
                    cety.addItem("Beijing");
                    break;
            //  ...
            }
        }
    });
    unity.addItem("Pakistan");
    unity.addItem("China");
    unity.addItem("America");
    unity.addItem("Japan");
    unity.addItem("Bangladesh");
    unity.addItem("Srilanka");
    unity.addItem("India");
    unity.addItem("Turkey");
    unity.addItem("UK");
    unity.addItem("Afghanistan");
    unity.addItem("Iran");
    unity.addItem("Iraq");

// This would be a workaround if you don't want to move the addItems:
//  unity.setSelectedIndex(1);
//  unity.setSelectedIndex(0);