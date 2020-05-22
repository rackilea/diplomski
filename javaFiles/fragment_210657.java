void setToggleButtonColor(ToggleButton tButton, int colour)
{
    LayerDrawable layerOn = (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.toggle_custom);
    layerOn.mutate();
    LayerDrawable layerOff = (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.toggle_custom_off);
    layerOff.mutate();
    Drawable toggleOn = layerOn.findDrawableByLayerId(R.id.mainColourOn);
    Drawable toggleOff = layerOff.findDrawableByLayerId(R.id.mainColourOff);

    toggleOn.setColorFilter(colour, PorterDuff.Mode.MULTIPLY);
    toggleOff.setColorFilter(colour, PorterDuff.Mode.MULTIPLY);

    StateListDrawable tbBackground = new StateListDrawable();

    tbBackground.addState(new int[]{android.R.attr.state_checked}, layerOn );
    tbBackground.addState(StateSet.WILD_CARD, layerOff);

    tButton.setBackgroundDrawable(tbBackground);

}