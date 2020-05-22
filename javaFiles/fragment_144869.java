JPanel p = new JPanel(new MigLayout("", "[right]"));

 p.add(new JLabel("General"),  "split, span, gaptop 10");
 p.add(new JSeparator(),       "growx, wrap, gaptop 10");

 p.add(new JLabel("Company"),  "gap 10");
 p.add(new JTextField(""),     "span, growx");
 p.add(new JLabel("Contact"),  "gap 10");
 p.add(new JTextField(""),     "span, growx, wrap");

 p.add(new JLabel("Propeller"),"split, span, gaptop 10");
 p.add(new JSeparator(),       "growx, wrap, gaptop 10");

 p.add(new JLabel("PTI/kW"),   "gap 10");
 p.add(new JTextField(10),     "");
 p.add(new JLabel("Power/kW"), "gap 10");
 p.add(new JTextField(10),     "wrap");
 p.add(new JLabel("R/mm"),     "gap 10");
 p.add(new JTextField(10),     "wrap");
 p.add(new JLabel("D/mm"),     "gap 10");
 p.add(new JTextField(10));