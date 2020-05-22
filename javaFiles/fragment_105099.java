JSeparator separate = new JSeparator(SwingConstants.HORIZONTAL);
System.out.println(separate.getPreferredSize());
System.out.println(separate.getMaximumSize());
Dimension d = separate.getPreferredSize();
d.width = separate.getMaximumSize().width;
separate.setMaximumSize( d );