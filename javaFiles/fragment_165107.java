// 1.0 Site Menu, S
JMenu siteMenu = new JMenu("Site");
siteMenu.setMnemonic(KeyEvent.VK_S);
mb.add(siteMenu);

// 1.1 Site->Website, W
JMenuItem websiteMenu = new JMenuItem("Website", KeyEvent.VK_W);
siteMenu.add(websiteMenu);

// 1.2 Site->Forum, F
JMenuItem forumMenu = new JMenuItem("Forum", KeyEvent.VK_F);
siteMenu.add(forumMenu);

// and so on