public ImageButton initializeBtn (int resid, boolean visible) {

    ImageButton btn = new ImageButton (this);// use this instead of getApplicationContext()
    btn.setBackgroundResource(resid);

    if (visible) btn.setVisibility(View.VISIBLE);
    else btn.setVisibility(View.INVISIBLE);
    return btn;
}