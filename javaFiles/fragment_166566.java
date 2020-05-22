Timer timer = new Timer(300, new ActionListener(){

     @Override
     public void actionPerformed(ActionEvent e) {
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               // runs code on the EDT to edit UI elements (recommended way)
               redo();
               repaint();
            }

         });  
     }
  });
  timer.setRepeats(false);
  timer.start();