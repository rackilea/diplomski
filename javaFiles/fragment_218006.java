InputMap iMap = theTaskWindow.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
     iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");
     ActionMap aMap = theTaskWindow.getRootPane().getActionMap();
     aMap.put("escape", new AbstractAction() {
      private static final long serialVersionUID = 1L;
      public void actionPerformed(ActionEvent e){
        doCancel();
      }
     });