public static void callPanelToSetText(final String value) {
  SwingUtilities.invokeLater(new Runnable() {

  @Override
    public void run() {
      doCallPanelToSetText(value);
    }
  });
}