ActionListener repaintTrigger = new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
          myComponent.repaint();
      }
};
new Timer(25, repaintTrigger).start();