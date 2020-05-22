Integer img = R.drawable.trans_grid_2;
int NUMBER_OF_IMAGES = 2;
for(int i=0; i<NUMBER_OF_IMAGES; i++) {
    ImageView iView = new ImageView(this);
    iView.setImageResource(img);

    constraintLayout.addView(iView);
}