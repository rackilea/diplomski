JList<?> list = SwingUtils.getDescendantOfType(JList.class, fileChooser, "Enabled", true);

MouseListener listener = new MouseAdapter() {

  @Override
  public void mousePressed(MouseEvent e) {
    File file = fileChooser.getSelectedFile();

   if (e.getClickCount() == 2 && file != null) {
      if (e.getSource() == list) {
        // Do your stuff
        operateOnFile(file);
      } 
      else {
        // Default operation
      }
    }       
  }
};

list.addMouseListener(listener);