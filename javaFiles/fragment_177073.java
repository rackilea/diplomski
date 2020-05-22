public StateListDrawable getSelectorDrawable(int color) {
    StateListDrawable out = new StateListDrawable();
    out.addState(new int[] { android.R.attr.state_pressed }, createNormalDrawable(color));
    out.addState(StateSet.WILD_CARD, createStrokeDrawable(color));
    return out;
}

public GradientDrawable createNormalDrawable(int color) {
    GradientDrawable out = new GradientDrawable();
    out.setColor(color);
    return out;
}

public GradientDrawable createStrokeDrawable(int color) {
    GradientDrawable out = new GradientDrawable();
    out.setStroke(1, color);
    return out;
}