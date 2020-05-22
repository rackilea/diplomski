// 3. Add components to panel panel
quartersL = new JLabel("Quarters");
dimesL = new JLabel("Dimes");
nickelsL = new JLabel("Nickels");
penniesL = new JLabel("Pennies");

panel.add(new JLabel("Enter Change (1-99):"));
panel.add(changeTF);
panel.add(quartersL);
panel.add(new JTextField(quarters));
panel.add(dimesL);
panel.add(new JTextField(dimes));
panel.add(nickelsL);
panel.add(new JTextField(nickels));
panel.add(penniesL);
panel.add(new JTextField(pennies));
panel.add(calculateBtn);
//content.add(clearBtn);