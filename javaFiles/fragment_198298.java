public static final Dimension PREF_SIZE = new Dimension(70, 80);

public DLabel()
{
    this.setBorder(BorderFactory.createBevelBorder(TOP, Color.white, 
         Color.black));
}

@Override
public Dimension getPreferredSize() {
  Dimension superDim = super.getPreferredSize();
  int width = Math.max(superDim.getWidth(), PREF_SIZE.getWidth());
  int height = Math.max(superDim.getHeight(), PREF_SIZE.getHeight()); 
  return new Dimension(width, height);
}