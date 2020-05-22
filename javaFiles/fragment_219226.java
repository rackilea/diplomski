ColorStateList csl = ColorStateList.valueOf(Color.BLUE);
RippleDrawable d = new RippleDrawable(csl, null, null);

// Change the color, if desired.
ColorStateList otherCsl = ColorStateList.valueOf(Color.RED);
d.setColor(otherCsl);