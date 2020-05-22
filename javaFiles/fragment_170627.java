HashMap<String, JTextField> hm = new HashMap<>();

// ........

hm.put("SecondFactorHREF", new JTextField());
hm.put("SplashPage", new JTextField());

for (Entry<String, JTextField> entry : hm.entrySet()) {
    key = entry.getKey();
    label =  new JLabel(key);
    // .... no done't set bounds -- use layout managers!
    // label.setBounds(x, y, widthLabel, heightLabel);
    field = entry.getValue();
    // field.setBounds(x+90,y,widthField,heightField);  // again use layout managers
    panel_2.add(label);
    panel_2.add(field);
}