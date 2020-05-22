//Submenu           
       subMenu = new JMenu("Paste");
       menuOptions.add(SubMenu); 

       JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
       JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
       JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
       subMenu .add(cut);

       paste.setText("Paste");
       cut.setText("Cut");
       copy.setText("Copy");

       subMenu .add(copy);
       subMenu .add(paste);