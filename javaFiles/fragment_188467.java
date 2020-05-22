JInternalFrame jInternalFrame = new JInternalFrame();
jMenuBar = new javax.swing.JMenuBar();
jMenu1 = new JMenu("Save");
jMenu2 = new JMenu("Open");
jMenuBar.add(jMenu1);
jMenuBar.add(jMenu2);
jInternalFrame.setJMenuBar(jMenuBar);
tabbedPane.addTab("tab3", jInternalFrame);