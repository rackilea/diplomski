public Dimension getPreferredSize() {
  if (myBuffImg != null) {
    return new Dimension(myBuffImg.getWidth(), myBuffImg.getHeight());
  } 
  // default return value
  return super.getPreferredSize();      
}