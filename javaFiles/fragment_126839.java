JPopupMenu popup1 = new JPopupMenu();
JPopupMenu popup2 = new JPopupMenu();

FreezActionListener freezer = new FreezActionListener(this);

JMenuItem freeze1 = new JMenuItem("freeze");
freeze1.addActionListener(freezer);
JMenuItem freeze2 = new JMenuItem("freeze");
freeze2.addActionListener(freezer);

UnFreezActionListener unfreezer = new UnFreezActionListener(this);

JMenuItem unfreeze1 = new JMenuItem("unfreeze");
unfreeze1.addActionListener(unfreezer);
JMenuItem unfreeze2 = new JMenuItem("unfreeze");
unfreeze2.addActionListener(unfreezer);

JMenuItem sortU = new JMenuItem("sort");
JMenuItem sortD = new JMenuItem("sort");



popup1.add(freeze1);
popup1.add(unfreeze1);
popup1.add(sortU);

popup2.add(freeze2);
popup2.add(unfreeze2);
popup2.add(sortD);