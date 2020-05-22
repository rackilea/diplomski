NumberFormatter nf = new NumberFormatter();
nf.setValueClass(Integer.class);
nf.setMinimum(new Integer(0));
nf.setMaximum(new Integer(100));

JFormattedTextField field = new JFormattedTextField(nf);