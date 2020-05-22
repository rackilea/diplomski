//a submenu
pluginsMenu.addSeparator();
   submenu = new JMenu("Plugin Name");

      //add one submenuItem
      menuItem = new JMenuItem("Config");
   submenu.add(menuItem);

       //add another submenuItem
       menuItem = new JMenuItem("Run/Execute");
   submenu.add(menuItem);

//add submenu to mainPluginMenu
pluginsMenu.add(submenu);