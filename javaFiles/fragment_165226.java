protected void buttonClick() {
  Runnable doStuff = new Runnable() {
    public void run() {
      // Do whatever button processing is needed here
    }
  };

  // Invoke later, so that any LostFocus event will have been processed first
  SwingUtilities.invokeLater(doListSelection);
}