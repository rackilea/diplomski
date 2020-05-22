JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "H.mm") {

    @Override
    public JFormattedTextField getTextField() {
      JFormattedTextField txt = super.getTextField();
      int start = txt.getSelectionStart();
      int length = txt.getText().length();
      if (start == length) {
        txt.setSelectionStart(length - 1);
      }

      return txt;
    }
  };