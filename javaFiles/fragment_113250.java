private static class AllowableInputFilter implements InputFilter {
    private boolean mAllowDot;

    public void setAllowDot(boolean toAllow) {
      mAllowDot = toAllow;
    }

    ....


    private boolean allowed(char c){
      return mAllowDot || c != '.';
    }
}

public void forceText(String text) {
  mInputFilter.setAllowDot(true);
  mEditText.setText(text);
  mInputFilter.setAllowDot(false);
}

mInputFilter = new AllowableInputFilter();
mInputFilter.setAllowDot(false);

mEditText.setFilters(new InputFilter[] {mInputFilter});

forceText("Okaaayy....");