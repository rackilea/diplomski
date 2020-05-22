public void consoleText(final String consoleUpdate){
 SwingUtilities.invokeLater(new Runnable() {
    public void run() {
      console.append(consoleUpdate);
    }
 });