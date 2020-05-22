float w_ratio = (targetImage.getMeasuredWidth() - sourceImage.getMeasuredWidth()) / sourceImage.getMeasuredWidth();
float h_ratio = (targetImage.getMeasuredHeight() - sourceImage.getMeasuredHeight()) / sourceImage.getMeasuredHeight();

// then animate:

v.animate().scaleXBy(w_ratio).scaleYBy(h_ratio).setDuration(1000);

// Don't forget to reset the size later if needed, using:

v.setScaleX(1.0f);
v.setScaleY(1.0f);