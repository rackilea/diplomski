txt_Appname.addVerifyListener(new VerifyListener() {
  @Override
  public void verifyText(VerifyEvent e) {
      String text = e.text;
      for (int i = 0; i < text.length(); i++) {
         if (!Character.isLetterOrDigit(text.charAt(i)) {
            e.doit = false;
            return;
         }
      }
  }
});