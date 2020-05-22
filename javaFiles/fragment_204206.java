menu = new JMenu("Tools");

       mi = new JMenuItem("Sort");
       menu.add(mi);
       mi = new JMenuItem("Search");
       menu.add(mi);
      JMenu med = new JMenu("Edit");
        mi = new JMenuItem("Copy");
       med.add(mi);
        mi = new JMenuItem("Paste");
       med.add(mi);
       menu.add(med);
     menubar.add(menu);