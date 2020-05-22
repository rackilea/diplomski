protected class CustomImageButtonBackgroundDrawable extends LayerDrawable { 

    protected Drawable lowerlayer;
    protected Drawable _highlightedDrawable;

    protected int _disabledAlpha = 100;
    protected Drawable _pressedDrawable;


    public CustomImageButtonBackgroundDrawable(Drawable d) {
          super(new Drawable[] { d });
    }

    @Override
    protected boolean onStateChange(int[] states) {
      boolean enabled = false;
      boolean highlighted = false;
      boolean pressed = false;

      for (int state : states) {
        if (state == android.R.attr.state_enabled)
            enabled = true;
        else if (state == android.R.attr.state_selected)
            highlighted = true;
        else if (state == android.R.attr.state_pressed)
            pressed = true;
      }

      mutate();
      if (enabled && highlighted) {
        ColorFilter colourFilter = new LightingColorFilter(Color.YELLOW, 1);
        ScaleDrawable resizedImage = new ScaleDrawable(background, 0, 1.25f, 1.25f);

        lowerlayer = resizedImage.getDrawable();
        lowerlayer.setColorFilter(colourFilter);

        Drawable[] aD = new Drawable[2];
        aD[0] = lowerlayer;
        aD[1] = background;
        LayerDrawable _highlightedDrawable = new LayerDrawable(aD);

        setBackgroundDrawable(_highlightedDrawable); // buttons need transparent backgrounds

      } else if (!enabled) {
        setColorFilter(null);
        setAlpha(_disabledAlpha);

      } else if (enabled && pressed){
        ScaleDrawable smaller = new ScaleDrawable(background, 0, 0.75f, 0.75f);

        setBackgroundDrawable(smaller.getDrawable());

      } else {
        setColorFilter(null);
      }

      invalidateSelf();

      return super.onStateChange(states);
    }

}