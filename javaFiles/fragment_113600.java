GridBagLayout lay = new GridBagLayout(); 
setLayout(lay);
// Add components
add(comp1, constraints);
add(comp2, constraints);
//
GridBagConstraints c = lay.getConstraints(comp1);
System.out.println(c.gridx + ", " + c.gridy);