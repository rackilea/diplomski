public void actionPerformed(ActionEvent evt) {
  tab.setSelectedIndex(1);

  SwingUtilities.invokeLater(new Runnable() {
    public void run() {
      // Do remaining work.
    }
  });
}