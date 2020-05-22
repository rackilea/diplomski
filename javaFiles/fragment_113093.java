@Override
  public void run() {
    mValues.open();
    mValues.updateText(id, s.toString());                               
    mValues.close();

}