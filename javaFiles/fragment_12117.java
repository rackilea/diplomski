int newAlpha = getIntent().getExtras().getInt("alphaForImageView");
b2.getBackground().setAlpha(newAlpha);

boolean hideImageView = getIntent().getExtras().getBoolean("hideImageView");
if (hideImageView) {
    v2.setVisibility(View.INVISIBLE);
}