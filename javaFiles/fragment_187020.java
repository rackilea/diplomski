// in the Fragment
private void sendColor(int color) {
    PaintingActivity activity = (PaintingActivity) getActivity();
    activity.setPaintbrushColor(color);
}

// in the Activity
public void setPaintbrushColor(int color) {
    myPaintbrushColor = color;
}